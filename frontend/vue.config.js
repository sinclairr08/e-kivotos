const { defineConfig } = require("@vue/cli-service");
const path = require("path");
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: path.resolve(__dirname, "../backend/src/main/resources/static"),
  devServer: {
    proxy: "http://localhost:24008",
  },
});
