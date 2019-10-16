package io.quarkus.hibernate.orm.ManyToOne;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.test.QuarkusUnitTest;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;

/**
 * @author Andrea Boriero
 */
public class ManyToOneTestCase {
    private static final Logger log = Logger.getLogger(ManyToOneTestCase.class);

    @RegisterExtension
    static QuarkusUnitTest runner = new QuarkusUnitTest()
            .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class)
                    .addClasses(Client.class, Office.class, Request.class, User.class, Log.class,
                            ManyToOneResource.class)
                    .addAsResource("application.properties")
                    .addAsResource(new StringAsset(""), "import.sql"));

    @Test
    public void testRequestHasAnAssociatedClient() {
        log.info(">>> Creating User with Office and Client");
        ResponseBody responseBody = RestAssured.given().header("Content-Type", MediaType.APPLICATION_JSON).when().post(
                "/manyToOne/create/user").body();
        log.info("User created <<<");

        Integer userId = responseBody.path("id");

        log.info(">>> Creating a Request associated with the created User");

        responseBody = RestAssured.given().when().post(
                "/manyToOne/create/request?userId=" + userId).body();

        log.info("Request created <<<");

        responseBody = RestAssured.given().header("Content-Type", MediaType.APPLICATION_JSON).when().get(
                "/manyToOne/request/client?requestId=" + responseBody.asString()).body();

        assertThat(responseBody.path("id"), not(nullValue()));
    }
}
