// The Typesafe repository
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.7")

addSbtPlugin("org.ensime" % "ensime-sbt" % "0.1.5")

dependencyOverrides += "org.scala-sbt" % "sbt" % "0.13.7"
