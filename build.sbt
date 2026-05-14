scalaVersion := "3.8.3"

logLevel := Level.Debug

exportJars := false

ThisBuild / usePipelining := true

lazy val a = project

lazy val b = project.dependsOn(a)
  .settings(
    run / fork := true,
    TaskKey[Unit]("foo") := Def.uncached{
      (Compile / runMain).toTask(s" example.B").value
    }
  )
