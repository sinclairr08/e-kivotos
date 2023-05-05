<template>
  <div class="w-full text-center text-2xl pt-2 font-bold">사이트 모음</div>
  <div class="grid grid-cols-2 mx-4">
    <div
      v-for="site in sites"
      :key="site.name"
      class="text-center p-2 m-2 border-gray-500 border-2 rounded-lg shadow"
    >
      <a :href="site.url" class="flex flex-col space-y-1.5">
        <img :src="`${site.imgSrc}`" />
        <span class="mt-12 font-bold text-sm">
          {{ site.name }}
        </span>
      </a>
    </div>
  </div>
</template>

<script setup>
const generateUrl = (name) => {
  return require(`@/assets/imgs/${name}.jpg`);
};
const sites = [
  {
    url: "https://forum.nexon.com/bluearchive/main",
    name: "한섭 공식 커뮤니티",
    imgSrc: generateUrl("official"),
  },
  {
    url: "https://gall.dcinside.com/mgallery/board/lists/?id=projectmx",
    name: "블루 아카이브 갤러리",
    imgSrc: generateUrl("gall"),
  },
  {
    url: "https://arca.live/b/bluearchive",
    name: "블루 아카이브 채널",
    imgSrc: generateUrl("channel"),
  },
  {
    url: "https://bluearchive.jp/",
    name: "일섭 공식 커뮤니티",
    imgSrc: generateUrl("jp"),
  },
  {
    url: "https://molunote.oopy.io/",
    name: "몰루노트",
    imgSrc: generateUrl("info"),
  },
  {
    url: "https://schale.gg/",
    name: "Schale gg",
    imgSrc: generateUrl("schale"),
  },
];
</script>
