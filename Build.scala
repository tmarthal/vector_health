import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "mhout-examples"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "be.objectify"  %%  "deadbolt-java"     % "2.1-SNAPSHOT",
      // Comment this for local development of the Play Authentication core
      "com.feth"      %%  "play-authenticate" % "0.2.5-SNAPSHOT",
      "postgresql"    %   "postgresql"        % "9.1-901-1.jdbc4",
      "org.apache.mahout" % "mahout-core" % "0.7",
      "org.apache.mahout" % "mahout-math" % "0.7",
      "org.apache.hadoop" % "hadoop-core" % "1.1.2",
      javaCore,
      javaJdbc,
      javaEbean
    )
    
    val main = play.Project(appName, appVersion, appDependencies).settings(

      resolvers += Resolver.url("Objectify Play Repository (release)", url("http://schaloner.github.com/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("Objectify Play Repository (snapshot)", url("http://schaloner.github.com/snapshots/"))(Resolver.ivyStylePatterns),

      resolvers += Resolver.url("play-easymail (release)", url("http://joscha.github.com/play-easymail/repo/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("play-easymail (snapshot)", url("http://joscha.github.com/play-easymail/repo/snapshots/"))(Resolver.ivyStylePatterns),

      resolvers += Resolver.url("play-authenticate (release)", url("http://joscha.github.com/play-authenticate/repo/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("play-authenticate (snapshot)", url("http://joscha.github.com/play-authenticate/repo/snapshots/"))(Resolver.ivyStylePatterns)
    )
}