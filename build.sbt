


  lazy val commonSettings = Seq(
    organization := "biz.ideasoft",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.11.7",
    scalacOptions in ThisBuild ++= Seq("-deprecation", "-feature", "-encoding", "utf8"),
    //  "-unchecked",
    scalacOptions in(ThisBuild, Test) ++= Seq("-Yrangepos"),
    javacOptions in ThisBuild ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "utf8"))
    //, "-Xlint:unchecked" "-Xlint:deprecation"))


  name := "strservice"


  // publishMavenStyle in ThisBuild := true
  parallelExecution in (ThisBuild) := true

  //parallelExecution in (ThisBuild, Test) := true
  parallelExecution in Test := false

  testOptions in Test += Tests.Setup(() => println("Setup: ------------------- "))

  testOptions in Test += Tests.Cleanup(() => println("Cleanup: -------------------"))


  // Add any command aliases that may be useful as shortcuts
  addCommandAlias("cc", ";clean;compile")

  addCommandAlias("rc", ";reload;compile")

  addCommandAlias("c", "compile")

  addCommandAlias("p", "project")

  val scalaTest = "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

  val springCore = "org.springframework" % "spring-core" % "4.2.1.RELEASE"
  val springContext = "org.springframework" % "spring-context" % "4.2.1.RELEASE"
  val springBeans = "org.springframework" % "spring-beans" % "4.2.1.RELEASE"
  val springWeb = "org.springframework" % "spring-web" % "4.2.1.RELEASE"

  val resteasyJaxrs = "org.jboss.resteasy" % "resteasy-jaxrs" % "3.0.12.Final"
  val resteasyServlet = "org.jboss.resteasy" % "resteasy-servlet-initializer" % "3.0.12.Final"
  val resteasyJackson2 = "org.jboss.resteasy" % "resteasy-jackson2-provider" % "3.0.12.Final"
  val resteasySpring = "org.jboss.resteasy" % "resteasy-spring" % "3.0.12.Final"

  val javaxServlet = "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"

  lazy val strserviceData = (project in file("strservice-data")).settings(commonSettings: _*)

  lazy val strserviceApi = (project in file("strservice-api")).dependsOn(strserviceData).settings(commonSettings: _*)

  lazy val strserviceCore = (project in file("strservice-core")).dependsOn(strserviceApi).settings(commonSettings: _*).settings(name := "strserviceCore", libraryDependencies ++= Seq(scalaTest))

  lazy val strserviceRest = (project in file("strservice-rest")).
    dependsOn(strserviceApi, strserviceCore).
    settings(commonSettings: _*).
    settings(
      name := "strserviceRest",
      libraryDependencies ++= Seq(scalaTest, springContext, springCore, springBeans, springWeb,
        resteasyJaxrs, resteasyServlet, resteasyJackson2, resteasySpring)
    )

  lazy val root = (project in file(".")) aggregate(strserviceData, strserviceApi, strserviceCore, strserviceRest)

    // disable .jar publishing
    //  publishArtifact in (Compile, packageBin) := false,
    // create an Artifact for publishing the .war file
    //      artifact in (Compile, packageWar) ~= { (art: Artifact) => art.copy(`type` = "war", extension = "war"),
    //}
    // add the .war file to what gets published
    //  addArtifact(artifact in (Compile, packageWar), packageWar),)

