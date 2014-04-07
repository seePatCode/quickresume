import play.Project._

name := "quickresume"

version := "1.0"

libraryDependencies ++= Seq(
  "net.vz.mongodb.jackson" %% "play-mongo-jackson-mapper" % "1.1.0"
)

playJavaSettings