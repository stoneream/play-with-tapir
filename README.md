# play-with-tapir

## プロジェクト構成

| プロジェクト | 内容                               |
| ------------ | ---------------------------------- |
| endpoint     | Tapir のエンドポイント定義         |
| server       | サーバー実装                       |
| gendoc       | OpenAPI Specification の生成ツール |
| logging      | ロギングユーティリティ             |

## OpenAPI Specification の生成

```
sbt "gendoc/run --output-dir docs"
```
