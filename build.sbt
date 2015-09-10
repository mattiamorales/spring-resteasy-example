

name := "strservice"

lazy val commonSettings = Seq(
  organization := "biz.ideasoft",
  version := "1.0-SNAPSHOT",
  scalaVersion := "2.11.7",
  scalacOptions in ThisBuild ++= Seq("-deprecation", "-feature", "-encoding", "utf8"),
  scalacOptions in(ThisBuild, Test) ++= Seq("-Yrangepos"),
  javacOptions in ThisBuild ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "utf8")
)

//  "-unchecked",, "-Xlint:unchecked" "-Xlint:deprecation"))
// publishMavenStyle in ThisBuild := true

parallelExecution in ThisBuild := false
//
parallelExecution in Test := false
//
testOptions in Test += Tests.Setup(() => println("Setup: ------------------- "))

testOptions in Test += Tests.Cleanup(() => println("Cleanup: -------------------"))


updateOptions := updateOptions.value.withCachedResolution(true)


lazy val servicesDomain = IdProject("services-domain")

lazy val strserviceApi = IdProject("strservice-stub/strservice-api").
  dependsOn(servicesDomain)

lazy val strserviceMock = IdProject("strservice-stub/strservice-mock").
  dependsOn(strserviceApi)

lazy val strserviceCore = IdProject("strservice-stub/strservice-core").
  dependsOn(strserviceApi).
  settings(
    libraryDependencies ++= Seq(scalaTest))
//    containerMain in Tomcat := "org.apache.catalina.startup.Bootstrap",

lazy val strserviceRestResteasy = IdProject("strservice-rest/strservice-rest-resteasy").
  dependsOn(strserviceApi).
  settings(
    libraryDependencies ++= Seq(scalaTest, springContext, springCore, springBeans, springWeb,
      resteasyJaxrs, resteasyServlet, resteasyJackson2, resteasySpring, javaxServlet)
  )

lazy val strserviceRestWeb = IdProject("strservice-rest/strservice-rest-web").
  dependsOn(strserviceApi, strserviceCore, strserviceMock, strserviceRestResteasy).
  enablePlugins(WarPlugin).
  enablePlugins(JettyPlugin).
  enablePlugins(TomcatPlugin).
  settings(
    containerLibs in Tomcat := Seq("com.github.jsimone" % "webapp-runner" % "8.0.24.0" intransitive()),
    libraryDependencies ++= Seq(scalaTest, springContext, springCore, springBeans, springWeb,
      resteasyJaxrs, resteasyServlet, resteasyJackson2, resteasySpring, javaxServlet)
  )

lazy val root = Project("root", file(".")).
  settings(commonSettings: _*).
  aggregate(servicesDomain, strserviceApi, strserviceCore, strserviceMock, strserviceRestResteasy, strserviceRestWeb).
  settings()

def IdProject(name: String) = {
  Project(name.split('/').last, file(name)).
    settings(
      commonSettings: _*
    )
}
