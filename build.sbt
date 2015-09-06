

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


lazy val strserviceData = IdProject("strservice-data")

lazy val strserviceApi = IdProject("strservice-api").
  dependsOn(strserviceData)

lazy val strserviceMock = IdProject("strservice-mock").
  dependsOn(strserviceApi)

lazy val strserviceCore = IdProject("strservice-core").
  dependsOn(strserviceApi).
  settings(
    libraryDependencies ++= Seq(scalaTest))

lazy val strserviceRest = IdProject("strservice-rest").
  dependsOn(strserviceApi, strserviceCore, strserviceMock % "compile->test").
  enablePlugins(WarPlugin).
  enablePlugins(JettyPlugin).
  settings(
    libraryDependencies ++= Seq(scalaTest, springContext, springCore, springBeans, springWeb,
      resteasyJaxrs, resteasyServlet, resteasyJackson2, resteasySpring, javaxServlet)
  )

lazy val root = Project("root", file(".")).
  settings(commonSettings: _*).
  aggregate(strserviceData, strserviceApi, strserviceCore, strserviceMock, strserviceRest).
  settings()

def IdProject(name: String) = {
  Project(name, file(name)).
    settings(
      commonSettings: _*
    )
}
