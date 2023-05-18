<template>
  <div class="w-full text-center text-2xl pt-2 font-bold">사이트 모음</div>

  <div class="flex flex-col space-y-2 justify-center mt-4">
    <div>
      <label class="ml-4 text-lg text-gray-900 font-bold">공식</label>
      <div class="flex">
        <SiteButton
          v-for="site in officalSites"
          :key="site.name"
          v-bind="site"
        />
      </div>
    </div>
    <div>
      <label class="ml-4 text-lg text-gray-900 font-bold">커뮤니티</label>
      <div class="flex">
        <SiteButton
          v-for="site in communitySites"
          :key="site.name"
          v-bind="site"
        />
      </div>
    </div>
    <div>
      <label class="ml-4 text-lg text-gray-900 font-bold"
        >기타 정보 사이트</label
      >
      <div class="flex">
        <SiteButton v-for="site in infoSites" :key="site.name" v-bind="site" />
      </div>
    </div>
  </div>
</template>

<script setup>
import SiteButton from "@/components/SiteButton.vue";

const generateUrl = (name) => {
  return require(`@/assets/thumbnails/${name}`);
};
const officalSites = [
  {
    name: "한섭 공식 커뮤니티",
    siteUrl: "https://forum.nexon.com/bluearchive/main",
    siteThumbnailUrl:
      "https://dszw1qtcnsa5e.cloudfront.net/bin/live/console-community-view/assets/common/pc-favicon.ico",
  },
  {
    name: "일섭 공식 커뮤니티",
    siteUrl: "https://bluearchive.jp/",
    siteThumbnailUrl:
      "https://webusstatic.yo-star.com/bluearchive_jp_web/favicon.ico",
  },
];
const communitySites = [
  {
    name: "블루 아카이브 갤러리",
    siteUrl: "https://gall.dcinside.com/mgallery/board/lists/?id=projectmx",
    siteThumbnailUrl: "https://nstatic.dcinside.com/dc/w/images/logo_icon.ico",
  },
  {
    name: "블루 아카이브 채널",
    siteUrl: "https://arca.live/b/bluearchive",
    siteThumbnailUrl:
      "https://arca.live/static/favicon.ico?t=704c3737398d0e9bb3371d4b502f0a5dd8efede3",
  },
];
const infoSites = [
  {
    name: "몰루노트 (정보)",
    siteUrl: "https://molunote.oopy.io/",
    siteThumbnailUrl:
      "https://oopy.lazyrockets.com/api/rest/cdn/image/231d22a7-3664-491f-b5f6-61ffaa4b40f0.png?d=16",
  },
  {
    name: "샬레지지 (DB)",
    siteUrl: "https://schale.gg/",
    siteThumbnailUrl: "https://schale.gg/favicon.png",
  },
  {
    name: "아로나 ai (재화 관리)",
    siteUrl: "https://arona.ai/",
    siteThumbnailUrl: generateUrl("aronaai.png"),
  },
];
</script>
