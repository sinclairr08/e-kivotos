import { createApp } from "vue";
import App from "./App.vue";
import store from "./store";
import routes from "./routes/index";
import "./index.css";

createApp(App).use(store).use(routes).mount("#app");
