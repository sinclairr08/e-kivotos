import { createApp } from "vue";
import App from "./App.vue";
import store from "./store";
import routes from "./routes";
import axios from "axios";
import "./index.css";

createApp(App).use(store).use(routes).provide("$axios", axios).mount("#app");
