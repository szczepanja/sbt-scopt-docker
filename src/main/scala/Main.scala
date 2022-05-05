object Main extends App {

  import scopt.OParser

  val builder = OParser.builder[Config]
  val parser1 = {
    import builder._
    OParser.sequence(
      programName("scopt"),
      head("scopt", "4.x"),
      opt[Int]('f', "foo")
        .action((x, c) => c.copy(foo = x))
        .text("foo is an integer property"),
      help("help").text("JACEK"),
    )
  }

  val path = args

  OParser.parse(parser1, path, Config()) match {
    case Some(config) => println(config)
    case _ => println("hello")
  }
}
