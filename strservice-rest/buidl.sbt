name := "strserviceRest"

version := "1.0-SNAPSHOT"

val javaxServlet = "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"

libraryDependencies ++= Seq(javaxServlet)

enablePlugins(WarPlugin)

//// disable .jar publishing
//publishArtifact in (Compile, packageBin) := false
//
//// create an Artifact for publishing the .war file
//artifact in (Compile, packageWar) ~= { (art: Artifact) =>
//  art.copy(`type` = "war", extension = "war")
//}
//
//// add the .war file to what gets published
//addArtifact(artifact in (Compile, packageWar), packageWar)