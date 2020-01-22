// Databricks notebook source
val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "9cc631de-cb6a-4910-9b94-1fd8c49014fa",
  "fs.azure.account.oauth2.client.secret" -> dbutils.secrets.get(scope = "adbtraining-scope", key = "dlstoken"),
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/72f988bf-86f1-41af-91ab-2d7cd011db47/oauth2/token")



// COMMAND ----------

dbutils.fs.mount(
  source = "abfss://fsname@dlsgen2name.dfs.core.windows.net/",
  mountPoint = "/mnt/data",
  extraConfigs = configs)