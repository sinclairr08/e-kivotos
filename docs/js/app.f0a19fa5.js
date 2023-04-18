(function(){var e={8690:function(e,t,n){"use strict";var o=n(9242),r=n(3396);const s={class:"my-12"};function l(e,t,n,o,l,a){const c=(0,r.up)("HeaderComponent"),i=(0,r.up)("router-view"),u=(0,r.up)("FooterComponent");return(0,r.wg)(),(0,r.iD)(r.HY,null,[(0,r.Wm)(c),(0,r._)("div",s,[(0,r.Wm)(i)]),(0,r.Wm)(u)],64)}const a={class:"w-full fixed top-0 p-3 flex items-center text-center bg-cyan-400 text-white"};function c(e,t){const n=(0,r.up)("router-link");return(0,r.wg)(),(0,r.iD)("div",a,[(0,r.Wm)(n,{to:"/",class:"mx-4"},{default:(0,r.w5)((()=>[(0,r.Uk)("Home")])),_:1}),(0,r.Wm)(n,{to:"/cost",class:"mx-4"},{default:(0,r.w5)((()=>[(0,r.Uk)("Cost")])),_:1}),(0,r.Wm)(n,{to:"/versions",class:"mx-4"},{default:(0,r.w5)((()=>[(0,r.Uk)("Versions")])),_:1})])}var i=n(89);const u={},p=(0,i.Z)(u,[["render",c]]);var f=p;const d={class:"w-full fixed bottom-0 p-3 flex flex-col text-center text-xs bg-cyan-400 text-white"},v=(0,r._)("span",null,"© 2023. e-kivotos ",-1),m=(0,r._)("span",null," e-kivotos는 넥슨 게임즈의 공식 서비스가 아니며, 모든 리소스의 저작권은 저작권자에게 있습니다",-1),g=[v,m];function x(e,t){return(0,r.wg)(),(0,r.iD)("div",d,g)}const b={},w=(0,i.Z)(b,[["render",x]]);var h=w,y={name:"App",components:{HeaderComponent:f,FooterComponent:h}};const _=(0,i.Z)(y,[["render",l]]);var k=_,j=(n(7658),n(65));const S=1e5,C=1e4,D="ADD_COST",O="INIT_COST",H="CLICK_CARD";var U=(0,j.MT)({state:{costValue:0,cards:[{name:"세리카",cost:2},{name:"이오리",cost:3},{name:"아루",cost:4},{name:"마키",cost:5},{name:"이로하",cost:6},{name:"히나",cost:7}],orders:[...Array(6).keys()]},mutations:{[D](e,{speed:t,regen:n}){const o=t*n;return e.costValue+o<=S?(e.costValue+=o,!0):(e.costValue=S,!1)},[O](e){e.costValue=0},[H](e,t){const{cost:n}=e.cards[e.orders[t]],o=n*C;e.costValue>=o&&(e.costValue-=o,e.orders.push(e.orders[t]),e.orders[t]=e.orders[3],e.orders.splice(3,1))}}}),V=n(2483),F=n(7139),z=n(4870),Y={__name:"VerticalLine",props:{idx:Number},setup(e){const t=e,n=(0,r.Fl)((()=>50*t.idx));return(e,t)=>((0,r.wg)(),(0,r.iD)("div",{class:"absolute h-6 border-l-[1px] border-solid border-white",style:(0,F.j5)([`left: ${(0,z.SU)(n)}px`])},null,4))}};const T=Y;var W=T;const A={class:""},K={class:""};var N={__name:"CharacterCard",props:{name:String,cost:Number,idx:Number},setup(e){const t=e,{commit:n}=(0,j.oR)(),o=()=>{n(H,t.idx)};return(t,n)=>((0,r.wg)(),(0,r.iD)("button",{class:"w-36 h-36 bg-gray-500 text-center flex flex-col items-center justify-center",onClick:o},[(0,r._)("span",A,(0,F.zw)(e.name),1),(0,r._)("span",K,(0,F.zw)(e.cost),1)]))}};const I=N;var M=I;const P={class:"flex justify-center"},Z={class:"flex items-center justify-center"},$={class:"text-white text-lg bg-sky-700 font-bold px-4 py-2 rounded-full"},L={class:"flex flex-col items-center justify-center"},E={class:"flex space-x-2 mt-2"},R={class:"mt-2 h-6 w-[500px] relative bg-sky-900"},q={class:"flex flex-col justify-center ml-2 mt-2"};var G={__name:"CostPage",setup(e){const{state:t,commit:n}=(0,j.oR)(),o=[.2,1,1.3,1.7],s=420,l=[...Array(11).keys()];let a;const c=(0,z.iH)(1),i=(0,z.iH)(!1),u=(0,z.iH)(0),p=(0,r.Fl)((()=>t.orders.slice(0,3).map((e=>t.cards[e])))),f=(0,r.Fl)((()=>Math.floor(t.costValue/C))),d=(0,r.Fl)((()=>100*t.costValue/S+"%")),v=(0,r.Fl)((()=>"▶".repeat(c.value))),m=(0,r.Fl)((()=>1==c.value?"bg-gray-400 text-gray-700 ":2==c.value?"bg-sky-400 text-sky-700 ":"bg-yellow-400 text-yellow-700 ")),g=(0,r.Fl)((()=>i.value?"bg-yellow-400 text-yellow-700 ":"bg-gray-400 text-gray-700 ")),x=()=>{a&&b(),a=setInterval((()=>{n(D,{speed:o[c.value],regen:s}),i.value&&t.costValue>=t.cards[t.orders[u.value]].cost*C&&(n(H,u.value),console.log(t.cards[t.orders[u.value]].cost),u.value=2==u.value?u.value-2:u.value+1)}),100)},b=()=>{clearInterval(a)},w=()=>{c.value=3==c.value?c.value-2:c.value+1},h=()=>{i.value=!i.value,i.value&&(u.value=0)};return(e,t)=>((0,r.wg)(),(0,r.iD)(r.HY,null,[(0,r._)("div",P,[(0,r._)("div",Z,[(0,r._)("span",$,(0,F.zw)((0,z.SU)(f)),1)]),(0,r._)("div",L,[(0,r._)("div",E,[((0,r.wg)(!0),(0,r.iD)(r.HY,null,(0,r.Ko)((0,z.SU)(p),((e,t)=>((0,r.wg)(),(0,r.j4)((0,z.SU)(M),(0,r.dG)({key:e.name,idx:t},e),null,16,["idx"])))),128))]),(0,r._)("div",R,[(0,r._)("div",{class:"absolute h-6 bg-sky-400",style:(0,F.j5)([`width: ${(0,z.SU)(d)}`])},null,4),((0,r.wg)(),(0,r.iD)(r.HY,null,(0,r.Ko)(l,(e=>(0,r.Wm)((0,z.SU)(W),{key:e,idx:e},null,8,["idx"]))),64))])]),(0,r._)("div",q,[(0,r._)("button",{class:(0,F.C_)((0,z.SU)(m)+"w-24 rounded text-lg py-0.5 text-center mb-0.5"),onClick:w},(0,F.zw)((0,z.SU)(v)),3),(0,r._)("button",{class:(0,F.C_)((0,z.SU)(g)+"w-24 text-center rounded text-lg py-0.5 mt-0.5 font-bold"),onClick:h}," AUTO ",2)])]),(0,r._)("div",{class:"mt-8 flex flex-col items-center"},[(0,r._)("button",{onClick:x},"Start"),(0,r._)("button",{onClick:b},"Stop")])],64))}};const B=G;var J=B;const Q=(0,r._)("div",{class:"w-full text-center text-2xl pt-2 font-bold"},"사이트 모음",-1),X={class:"grid grid-cols-2 mx-4"},ee=["href"],te=["src"],ne={class:"mt-12 font-bold text-sm"};var oe={__name:"MainPage",setup(e){const t=e=>n(8768)(`./${e}.jpg`),o=[{url:"https://forum.nexon.com/bluearchive/main",name:"한섭 공식 커뮤니티",imgSrc:t("official")},{url:"https://gall.dcinside.com/mgallery/board/lists/?id=projectmx",name:"블루 아카이브 갤러리",imgSrc:t("gall")},{url:"https://arca.live/b/bluearchive",name:"블루 아카이브 채널",imgSrc:t("channel")},{url:"https://bluearchive.jp/",name:"일섭 공식 커뮤니티",imgSrc:t("jp")},{url:"https://boatneck-telescope-7e9.notion.site/2df4987277984be9a07ec1efa27279e3",name:"블루아카 공략집",imgSrc:t("info")},{url:"https://schale.gg/",name:"Schale gg",imgSrc:t("schale")}];return(e,t)=>((0,r.wg)(),(0,r.iD)(r.HY,null,[Q,(0,r._)("div",X,[((0,r.wg)(),(0,r.iD)(r.HY,null,(0,r.Ko)(o,(e=>(0,r._)("div",{key:e.name,class:"text-center p-2 m-2 border-gray-500 border-2 rounded-lg shadow"},[(0,r._)("a",{href:e.url,class:"flex flex-col space-y-1.5"},[(0,r._)("img",{src:`${e.imgSrc}`},null,8,te),(0,r._)("span",ne,(0,F.zw)(e.name),1)],8,ee)]))),64))])],64))}};const re=oe;var se=re,le=n(4161);const ae={key:0,class:"flex flex-col border-b-2 border-purple-900"},ce={class:"ml-4 text-xs"},ie={key:1,class:"flex justify-center mt-4"};var ue={__name:"VersionPage",setup(e){const t=(0,z.iH)({}),n=(0,z.iH)("Loading...");return(0,r.bv)((async()=>{try{const{data:e}=await le.Z.get("http://ec2-3-39-68-209.ap-northeast-2.compute.amazonaws.com:8080/versions");t.value=e,n.value=""}catch(e){n.value=e}})),(e,o)=>((0,r.wg)(),(0,r.iD)(r.HY,null,[t.value?((0,r.wg)(),(0,r.iD)("div",ae,[((0,r.wg)(!0),(0,r.iD)(r.HY,null,(0,r.Ko)(t.value,(e=>((0,r.wg)(),(0,r.iD)("div",{class:"border-t-2 border-purple-900 p-4",key:e.versionString},[(0,r._)("div",null,[(0,r._)("span",null,"Ver. "+(0,F.zw)(e.versionString),1),(0,r._)("span",ce,(0,F.zw)(e.releaseDate),1)]),((0,r.wg)(!0),(0,r.iD)(r.HY,null,(0,r.Ko)(e.updates,(e=>((0,r.wg)(),(0,r.iD)("li",{key:e,class:"ml-2"},(0,F.zw)(e),1)))),128))])))),128))])):(0,r.kq)("",!0),n.value?((0,r.wg)(),(0,r.iD)("div",ie,[(0,r._)("span",null,(0,F.zw)(n.value),1)])):(0,r.kq)("",!0)],64))}};const pe=ue;var fe=pe,de=new V.p7({history:(0,V.r5)("/e-kivotos"),routes:[{path:"/",component:se},{path:"/cost",component:J},{path:"/versions",component:fe}]});(0,o.ri)(k).use(U).use(de).provide("$axios",le.Z).mount("#app")},8768:function(e,t,n){var o={"./channel.jpg":4496,"./gall.jpg":4883,"./info.jpg":4116,"./jp.jpg":1837,"./official.jpg":2245,"./schale.jpg":1063};function r(e){var t=s(e);return n(t)}function s(e){if(!n.o(o,e)){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}return o[e]}r.keys=function(){return Object.keys(o)},r.resolve=s,e.exports=r,r.id=8768},4496:function(e,t,n){"use strict";e.exports=n.p+"img/channel.05f337e5.jpg"},4883:function(e,t,n){"use strict";e.exports=n.p+"img/gall.4ccded9e.jpg"},4116:function(e,t,n){"use strict";e.exports=n.p+"img/info.87eca406.jpg"},1837:function(e,t,n){"use strict";e.exports=n.p+"img/jp.0b242caf.jpg"},2245:function(e,t,n){"use strict";e.exports=n.p+"img/official.c9b40c82.jpg"},1063:function(e,t,n){"use strict";e.exports=n.p+"img/schale.b76764a0.jpg"}},t={};function n(o){var r=t[o];if(void 0!==r)return r.exports;var s=t[o]={exports:{}};return e[o](s,s.exports,n),s.exports}n.m=e,function(){var e=[];n.O=function(t,o,r,s){if(!o){var l=1/0;for(u=0;u<e.length;u++){o=e[u][0],r=e[u][1],s=e[u][2];for(var a=!0,c=0;c<o.length;c++)(!1&s||l>=s)&&Object.keys(n.O).every((function(e){return n.O[e](o[c])}))?o.splice(c--,1):(a=!1,s<l&&(l=s));if(a){e.splice(u--,1);var i=r();void 0!==i&&(t=i)}}return t}s=s||0;for(var u=e.length;u>0&&e[u-1][2]>s;u--)e[u]=e[u-1];e[u]=[o,r,s]}}(),function(){n.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return n.d(t,{a:t}),t}}(),function(){n.d=function(e,t){for(var o in t)n.o(t,o)&&!n.o(e,o)&&Object.defineProperty(e,o,{enumerable:!0,get:t[o]})}}(),function(){n.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"===typeof window)return window}}()}(),function(){n.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)}}(),function(){n.p="/e-kivotos/"}(),function(){var e={143:0};n.O.j=function(t){return 0===e[t]};var t=function(t,o){var r,s,l=o[0],a=o[1],c=o[2],i=0;if(l.some((function(t){return 0!==e[t]}))){for(r in a)n.o(a,r)&&(n.m[r]=a[r]);if(c)var u=c(n)}for(t&&t(o);i<l.length;i++)s=l[i],n.o(e,s)&&e[s]&&e[s][0](),e[s]=0;return n.O(u)},o=self["webpackChunke_kivotos"]=self["webpackChunke_kivotos"]||[];o.forEach(t.bind(null,0)),o.push=t.bind(null,o.push.bind(o))}();var o=n.O(void 0,[998],(function(){return n(8690)}));o=n.O(o)})();
//# sourceMappingURL=app.f0a19fa5.js.map