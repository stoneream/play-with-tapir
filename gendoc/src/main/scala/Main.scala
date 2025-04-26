import better.files.File
import healthz.CliOption
import scopt.OParser
import sttp.apispec.openapi.circe.yaml.*
import sttp.tapir.docs.openapi.OpenAPIDocsInterpreter

object Main {
  def main(args: Array[String]): Unit = {
    val parser = {
      val builder = OParser.builder[CliOption]
      import builder.*

      OParser.sequence(
        programName("gendoc"),
        head("gendoc", "0.0.1"),
        opt[String]('o', "output-dir")
          .action((x, c) => c.copy(outputDir = x))
          .validate(x => if (x.nonEmpty) success else failure("出力先ディレクトリは空にすることはできません"))
          .validate(x => if (x.matches("^[a-zA-Z0-9_\\-]+$")) success else failure("出力先ディレクトリ名は英数字とアンダースコア、ハイフンのみを使用できます"))
          .text("出力先ディレクトリ")
      )
    }

    OParser.parse(parser, args, CliOption()) match {
      case Some(config) =>
        val docs = List(
          OpenAPIDocsInterpreter().toOpenAPI(healthz.Endpoints.endpoints, "health", "1.0")
        )

        docs.foreach { doc =>
          val file = File(s"${config.outputDir}/${doc.info.title}.yaml")
          file.createIfNotExists(createParents = true)
          file.write(doc.toYaml)
          println(s"ドキュメントを ${file.path} に出力しました")
        }
      case _ => println("引数の解析に失敗しました")
    }
  }
}
