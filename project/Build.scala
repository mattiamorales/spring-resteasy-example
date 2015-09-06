import sbt._

/**
 * Created by daniel on 6/9/15.
 */
object Common extends Build {

  val springVersion = "4.2.1.RELEASE"
  val resteasyVersion = "3.0.12.Final"
  val scalaTestVersion = "2.2.4"

  val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % "test"

  val springCore = "org.springframework" % "spring-core" % springVersion
  val springContext = "org.springframework" % "spring-context" % springVersion
  val springBeans = "org.springframework" % "spring-beans" % springVersion
  val springWeb = "org.springframework" % "spring-web" % springVersion

  val resteasyJaxrs = "org.jboss.resteasy" % "resteasy-jaxrs" % resteasyVersion
  val resteasyServlet = "org.jboss.resteasy" % "resteasy-servlet-initializer" % resteasyVersion
  val resteasyJackson2 = "org.jboss.resteasy" % "resteasy-jackson2-provider" % resteasyVersion
  val resteasySpring = "org.jboss.resteasy" % "resteasy-spring" % resteasyVersion

  val javaxServlet = "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"

}
