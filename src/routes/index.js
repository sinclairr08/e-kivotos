import { createRouter, createWebHashHistory } from "vue-router";
import CostPage from "../components/CostPage";
import MainPage from "../components/MainPage";
import VersionPage from "../components/VersionPage";

export default new createRouter({
  history: createWebHashHistory("/e-kivotos"),
  routes: [
    { path: "/", component: MainPage },
    { path: "/cost", component: CostPage },
    { path: "/versions", component: VersionPage },
  ],
});
