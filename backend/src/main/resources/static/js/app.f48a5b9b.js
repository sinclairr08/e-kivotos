(function(){var e={3377:function(e,t,s){"use strict";var l=s(9242),n=s(3396),a=s(4870);const r={class:"w-full fixed top-0 p-3 flex items-center text-center bg-cyan-400 text-white"};function o(e,t){const s=(0,n.up)("router-link");return(0,n.wg)(),(0,n.iD)("div",r,[(0,n.Wm)(s,{to:"/",class:"mx-4"},{default:(0,n.w5)((()=>[(0,n.Uk)("메인")])),_:1}),(0,n.Wm)(s,{to:"/cost",class:"mx-4"},{default:(0,n.w5)((()=>[(0,n.Uk)("코스트")])),_:1}),(0,n.Wm)(s,{to:"/recruit",class:"mx-4"},{default:(0,n.w5)((()=>[(0,n.Uk)("모집")])),_:1}),(0,n.Wm)(s,{to:"/versions",class:"mx-4"},{default:(0,n.w5)((()=>[(0,n.Uk)("버전")])),_:1})])}var i=s(89);const c={},u=(0,i.Z)(c,[["render",o]]);var d=u;const v={class:"w-full fixed bottom-0 p-3 flex flex-col text-center text-xs bg-cyan-400 text-white"},p=(0,n._)("span",null,"© 2023. e-kivotos ",-1),f=(0,n._)("span",null," e-kivotos는 넥슨 게임즈의 공식 서비스가 아니며, 모든 리소스의 저작권은 저작권자에게 있습니다",-1),m=[p,f];function g(e,t){return(0,n.wg)(),(0,n.iD)("div",v,m)}const x={},b=(0,i.Z)(x,[["render",g]]);var w=b;const h={class:"mt-12 mb-20"};var y={__name:"App",setup(e){return(e,t)=>{const s=(0,n.up)("router-view");return(0,n.wg)(),(0,n.iD)(n.HY,null,[(0,n.Wm)((0,a.SU)(d)),(0,n._)("div",h,[(0,n.Wm)(s)]),(0,n.Wm)((0,a.SU)(w))],64)}}};const _=y;var k=_,U=(s(7658),s(65));const D=1e5,C=1e4,S="ADD_COST",j="INIT_COST",H="CLICK_CARD";var O=(0,U.MT)({state:{costValue:0,cards:[],orders:[...Array(6).keys()]},mutations:{[S](e,{speed:t,regen:s}){const l=t*s;return e.costValue+l<=D?(e.costValue+=l,!0):(e.costValue=D,!1)},[j](e){e.costValue=0},[H](e,t){const{cost:s}=e.cards[e.orders[t]],l=s*C;e.costValue>=l&&(e.costValue-=l,e.orders.push(e.orders[t]),e.orders[t]=e.orders[3],e.orders.splice(3,1))}}}),T=s(2483),z=s(7139),V={__name:"VerticalLine",props:{idx:Number},setup(e){const t=e,s=(0,n.Fl)((()=>50*t.idx));return(e,t)=>((0,n.wg)(),(0,n.iD)("div",{class:"absolute h-6 border-l-[1px] border-solid border-white",style:(0,z.j5)([`left: ${(0,a.SU)(s)}px`])},null,4))}};const Y=V;var F=Y;const W={class:""},K={class:""};var Z={__name:"CharacterCard",props:{name:String,cost:Number,idx:Number},setup(e){const t=e,{commit:s}=(0,U.oR)(),l=()=>{s(H,t.idx)};return(t,s)=>((0,n.wg)(),(0,n.iD)("button",{class:"w-36 h-36 bg-gray-500 text-center flex flex-col items-center justify-center",onClick:l},[(0,n._)("span",W,(0,z.zw)(e.name),1),(0,n._)("span",K,(0,z.zw)(e.cost),1)]))}};const A=Z;var M=A,N=s(4161);const P={class:"flex flex-col items-center justify-center mt-16"},I={class:"flex items-center justify-center"},L={class:"text-white text-lg bg-sky-700 font-bold px-4 py-2 rounded-full"},E={class:"flex flex-col items-center justify-center"},G={class:"flex space-x-2 mt-2"},R={class:"mt-2 h-6 w-[500px] relative bg-sky-900"},$={class:"flex flex-col justify-center ml-2 mt-2"},q={class:"grid grid-cols-10 mt-6"},B=["onClick"],J={class:"mt-4"};var Q={__name:"CostPage",setup(e){const{state:t,commit:s}=(0,U.oR)(),l=(0,T.tv)(),r=[.2,1,1.3,1.7],o=420,i=[...Array(11).keys()];let c;const u=(0,a.iH)([]),d=(0,a.iH)(1),v=(0,a.iH)(!1),p=(0,a.iH)(0),f=(0,a.iH)("Loading..."),m=(0,n.Fl)((()=>6==t.cards.length?t.orders.slice(0,3).map((e=>t.cards[e])):[])),g=(0,n.Fl)((()=>Math.floor(t.costValue/C))),x=(0,n.Fl)((()=>100*t.costValue/D+"%")),b=(0,n.Fl)((()=>"▶".repeat(d.value))),w=(0,n.Fl)((()=>1==d.value?"bg-gray-400 text-gray-700 ":2==d.value?"bg-sky-400 text-sky-700 ":"bg-yellow-400 text-yellow-700 ")),h=(0,n.Fl)((()=>v.value?"bg-yellow-400 text-yellow-700 ":"bg-gray-400 text-gray-700 ")),y=e=>{u.value[e]={...u.value[e],clicked:!u.value[e].clicked}},_=()=>{let e=u.value.filter((e=>!0===e.clicked));if(6!=e.length)return f.value="6명을 선택하세요",void(t.cards=[]);t.cards=e},k=()=>{c&&j(),c=setInterval((()=>{s(S,{speed:r[d.value],regen:o}),v.value&&t.costValue>=t.cards[t.orders[p.value]].cost*C&&(s(H,p.value),p.value=2==p.value?p.value-2:p.value+1)}),100)},j=()=>{clearInterval(c)},O=()=>{d.value=3==d.value?d.value-2:d.value+1},V=()=>{v.value=!v.value,v.value&&(p.value=0)};return(0,n.wF)((async()=>{try{const{data:e}=await N.Z.get("/api/students/cost");u.value=e,f.value=""}catch(e){500===e.response.status?await l.push("/500"):f.value=e.response.status.toString()}})),(e,t)=>((0,n.wg)(),(0,n.iD)("div",P,[(0,n._)("div",I,[(0,n._)("span",L,(0,z.zw)((0,a.SU)(g)),1),(0,n._)("div",E,[(0,n._)("div",G,[((0,n.wg)(!0),(0,n.iD)(n.HY,null,(0,n.Ko)((0,a.SU)(m),((e,t)=>((0,n.wg)(),(0,n.j4)((0,a.SU)(M),(0,n.dG)({key:e.name,idx:t},e),null,16,["idx"])))),128))]),(0,n._)("div",R,[(0,n._)("div",{class:"absolute h-6 bg-sky-400",style:(0,z.j5)([`width: ${(0,a.SU)(x)}`])},null,4),((0,n.wg)(),(0,n.iD)(n.HY,null,(0,n.Ko)(i,(e=>(0,n.Wm)((0,a.SU)(F),{key:e,idx:e},null,8,["idx"]))),64))])]),(0,n._)("div",$,[(0,n._)("button",{class:(0,z.C_)((0,a.SU)(w)+"w-24 rounded text-lg py-0.5 text-center mb-0.5"),onClick:O},(0,z.zw)((0,a.SU)(b)),3),(0,n._)("button",{class:(0,z.C_)((0,a.SU)(h)+"w-24 text-center rounded text-lg py-0.5 mt-0.5 font-bold"),onClick:V}," AUTO ",2)])]),(0,n._)("button",{class:"mt-8",onClick:k},"시작"),(0,n._)("button",{class:"mt-2",onClick:j},"일시 정지"),(0,n._)("div",q,[((0,n.wg)(!0),(0,n.iD)(n.HY,null,(0,n.Ko)(u.value,((e,t)=>((0,n.wg)(),(0,n.iD)("button",{key:e.name,class:(0,z.C_)((e.clicked?"text-red-600":"text-gray-900")+" flex items-center justify-center text-xs m-0.5 border-2 border-gray-900 rounded-md px-0.5"),onClick:e=>y(t)},(0,z.zw)(e.name),11,B)))),128))]),(0,n._)("button",{class:"mt-4",onClick:_},"학생 선택"),(0,n._)("div",J,(0,z.zw)(f.value),1)]))}};const X=Q;var ee=X;const te={class:"text-center p-2 m-2 border-gray-500 border-2 rounded-lg shadow w-48"},se=["href"],le=["src"],ne={class:"mt-12 font-bold text-sm"};var ae={__name:"SiteButton",props:{name:String,siteUrl:String,siteThumbnailUrl:String},setup(e){return(t,s)=>((0,n.wg)(),(0,n.iD)("div",te,[(0,n._)("a",{href:e.siteUrl,class:"flex flex-col items-center space-y-1.5"},[(0,n._)("img",{src:e.siteThumbnailUrl,class:"w-16 h-16"},null,8,le),(0,n._)("span",ne,(0,z.zw)(e.name),1)],8,se)]))}};const re=ae;var oe=re;const ie=(0,n._)("div",{class:"w-full text-center text-2xl pt-2 font-bold"},"사이트 모음",-1),ce={class:"flex flex-col space-y-2 justify-center mt-4"},ue=(0,n._)("label",{class:"ml-4 text-lg text-gray-900 font-bold"},"공식",-1),de={class:"flex"},ve=(0,n._)("label",{class:"ml-4 text-lg text-gray-900 font-bold"},"커뮤니티",-1),pe={class:"flex"},fe=(0,n._)("label",{class:"ml-4 text-lg text-gray-900 font-bold"},"기타 정보 사이트",-1),me={class:"flex"};var ge={__name:"MainPage",setup(e){const t=e=>s(9166)(`./${e}`),l=[{name:"한섭 공식 커뮤니티",siteUrl:"https://forum.nexon.com/bluearchive/main",siteThumbnailUrl:"https://dszw1qtcnsa5e.cloudfront.net/bin/live/console-community-view/assets/common/pc-favicon.ico"},{name:"일섭 공식 커뮤니티",siteUrl:"https://bluearchive.jp/",siteThumbnailUrl:"https://webusstatic.yo-star.com/bluearchive_jp_web/favicon.ico"}],a=[{name:"블루 아카이브 갤러리",siteUrl:"https://gall.dcinside.com/mgallery/board/lists/?id=projectmx",siteThumbnailUrl:"https://nstatic.dcinside.com/dc/w/images/logo_icon.ico"},{name:"블루 아카이브 채널",siteUrl:"https://arca.live/b/bluearchive",siteThumbnailUrl:"https://arca.live/static/favicon.ico?t=704c3737398d0e9bb3371d4b502f0a5dd8efede3"}],r=[{name:"몰루노트 (정보)",siteUrl:"https://molunote.oopy.io/",siteThumbnailUrl:"https://oopy.lazyrockets.com/api/rest/cdn/image/231d22a7-3664-491f-b5f6-61ffaa4b40f0.png?d=16"},{name:"샬레지지 (DB)",siteUrl:"https://schale.gg/",siteThumbnailUrl:"https://schale.gg/favicon.png"},{name:"아로나 ai (재화 관리)",siteUrl:"https://arona.ai/",siteThumbnailUrl:t("aronaai.png")}];return(e,t)=>((0,n.wg)(),(0,n.iD)(n.HY,null,[ie,(0,n._)("div",ce,[(0,n._)("div",null,[ue,(0,n._)("div",de,[((0,n.wg)(),(0,n.iD)(n.HY,null,(0,n.Ko)(l,(e=>(0,n.Wm)(oe,(0,n.dG)({key:e.name},e),null,16))),64))])]),(0,n._)("div",null,[ve,(0,n._)("div",pe,[((0,n.wg)(),(0,n.iD)(n.HY,null,(0,n.Ko)(a,(e=>(0,n.Wm)(oe,(0,n.dG)({key:e.name},e),null,16))),64))])]),(0,n._)("div",null,[fe,(0,n._)("div",me,[((0,n.wg)(),(0,n.iD)(n.HY,null,(0,n.Ko)(r,(e=>(0,n.Wm)(oe,(0,n.dG)({key:e.name},e),null,16))),64))])])])],64))}};const xe=ge;var be=xe;const we={key:0,class:"flex flex-col border-b-2 border-purple-900"},he={class:"ml-4 text-xs"},ye={key:1,class:"flex justify-center mt-4"};var _e={__name:"VersionPage",setup(e){const t=(0,a.iH)({}),s=(0,a.iH)("Loading..."),l=(0,T.tv)();return(0,n.bv)((async()=>{try{const{data:e}=await N.Z.get("/api/versions");t.value=e,s.value=""}catch(e){500===e.response.status?await l.push("/500"):s.value=e.response.status.toString()}})),(e,l)=>((0,n.wg)(),(0,n.iD)(n.HY,null,[t.value?((0,n.wg)(),(0,n.iD)("div",we,[((0,n.wg)(!0),(0,n.iD)(n.HY,null,(0,n.Ko)(t.value,(e=>((0,n.wg)(),(0,n.iD)("div",{class:"border-t-2 border-purple-900 p-4",key:e.versionString},[(0,n._)("div",null,[(0,n._)("span",null,"Ver. "+(0,z.zw)(e.versionString),1),(0,n._)("span",he,(0,z.zw)(e.releaseDate),1)]),((0,n.wg)(!0),(0,n.iD)(n.HY,null,(0,n.Ko)(e.updates,(e=>((0,n.wg)(),(0,n.iD)("li",{key:e,class:"ml-2"},(0,z.zw)(e),1)))),128))])))),128))])):(0,n.kq)("",!0),s.value?((0,n.wg)(),(0,n.iD)("div",ye,[(0,n._)("span",null,(0,z.zw)(s.value),1)])):(0,n.kq)("",!0)],64))}};const ke=_e;var Ue=ke;const De={class:"mt-16 flex flex-col space-y-4 items-center"},Ce=(0,n._)("h1",{class:"font-bold"},"404 Not Found",-1),Se=(0,n._)("h1",null,"주소가 잘못되었습니다. 상단의 메인 버튼을 눌러 주세요",-1),je=[Ce,Se];function He(e,t){return(0,n.wg)(),(0,n.iD)("div",De,je)}const Oe={},Te=(0,i.Z)(Oe,[["render",He]]);var ze=Te;const Ve={class:"flex flex-col items-center space-y-4 mt-16"},Ye=(0,n._)("div",{class:"text-xl font-bold"},"상시 모집",-1),Fe={class:"grid grid-cols-5 w-1/2"},We={class:"flex justify-center space-x-4"};var Ke={__name:"RecruitPage",setup(e){let t,s,l=[],r=[];const o=(0,a.iH)("모집하기"),i=(0,a.iH)([]),c=(0,a.iH)("Loading..."),u=(0,T.tv)(),d=e=>1==e?"bg-blue-300":2==e?"bg-yellow-300":"bg-purple-300",v=()=>{"결과 확인"==o.value?o.value="한 번 더!":(o.value="결과 확인",p())},p=()=>{i.value=[],l=f();for(let e=0;e<10;e++)r[e]=setTimeout((()=>{i.value.push(l[e])}),200*(e+1))},f=()=>Array(10).fill(0).map(((e,t)=>m(t))),m=e=>{const l=9==e?s:t,n=100*Math.random();let a=0;while(n>l[a].prob)a++;return l[a]},g=async()=>{let e;try{const{data:t}=await N.Z.get("/api/students/recruit");e=t,c.value=""}catch(o){500===o.response.status?await u.push("/500"):c.value=o.response.status.toString()}const t=[0,0,0,0];for(let i=0;i<e.length;i++)t[e[i].star]++;const s=[0,78.5,18.5,3],l=[0,0,97,3];for(let i=1;i<=3;i++)s[i]/=t[i],l[i]/=t[i];let n=0;const a=e.map((e=>(n+=s[e.star],{...e,prob:n})));n=0;const r=e.filter((e=>e.star>1)).map((e=>(n+=l[e.star],{...e,prob:n})));return[a,r]};return(0,n.bv)((async()=>{[t,s]=await g()})),(0,n.Jd)((()=>{r.forEach((e=>clearTimeout(e)))})),(e,t)=>((0,n.wg)(),(0,n.iD)("div",Ve,[Ye,(0,n._)("div",Fe,[((0,n.wg)(!0),(0,n.iD)(n.HY,null,(0,n.Ko)(i.value,((e,t)=>((0,n.wg)(),(0,n.iD)("div",{key:t,class:(0,z.C_)(d(e.star)+" text-center m-2 py-1/4 text-sm")},(0,z.zw)("결과 확인"!=o.value?e.name:"★"),3)))),128))]),(0,n._)("div",We,[(0,n._)("button",{class:"p-2 bg-sky-400 rounded-md font-bold text-gray-900",onClick:v},(0,z.zw)(o.value),1)]),(0,n._)("div",null,(0,z.zw)(c.value),1)]))}};const Ze=Ke;var Ae=Ze;const Me={class:"mt-16 flex flex-col space-y-4 items-center"},Ne=(0,n._)("h1",{class:"font-bold"},"500 Internal Server Error",-1),Pe=(0,n._)("h1",null,"서버에 문제가 있습니다. 상단의 메인 버튼을 눌러 주세요",-1),Ie=[Ne,Pe];function Le(e,t){return(0,n.wg)(),(0,n.iD)("div",Me,Ie)}const Ee={},Ge=(0,i.Z)(Ee,[["render",Le]]);var Re=Ge,$e=new T.p7({history:(0,T.PO)("/"),routes:[{path:"/",component:be},{path:"/cost",component:ee},{path:"/versions",component:Ue},{path:"/recruit",component:Ae},{path:"/404",component:ze},{path:"/500",component:Re},{path:"/:pathMatch(.*)*",redirect:"/404"}]});(0,l.ri)(k).use(O).use($e).provide("$axios",N.Z).mount("#app")},9166:function(e,t,s){var l={"./aronaai.png":4575};function n(e){var t=a(e);return s(t)}function a(e){if(!s.o(l,e)){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}return l[e]}n.keys=function(){return Object.keys(l)},n.resolve=a,e.exports=n,n.id=9166},4575:function(e,t,s){"use strict";e.exports=s.p+"img/aronaai.cc3d1907.png"}},t={};function s(l){var n=t[l];if(void 0!==n)return n.exports;var a=t[l]={exports:{}};return e[l](a,a.exports,s),a.exports}s.m=e,function(){var e=[];s.O=function(t,l,n,a){if(!l){var r=1/0;for(u=0;u<e.length;u++){l=e[u][0],n=e[u][1],a=e[u][2];for(var o=!0,i=0;i<l.length;i++)(!1&a||r>=a)&&Object.keys(s.O).every((function(e){return s.O[e](l[i])}))?l.splice(i--,1):(o=!1,a<r&&(r=a));if(o){e.splice(u--,1);var c=n();void 0!==c&&(t=c)}}return t}a=a||0;for(var u=e.length;u>0&&e[u-1][2]>a;u--)e[u]=e[u-1];e[u]=[l,n,a]}}(),function(){s.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return s.d(t,{a:t}),t}}(),function(){s.d=function(e,t){for(var l in t)s.o(t,l)&&!s.o(e,l)&&Object.defineProperty(e,l,{enumerable:!0,get:t[l]})}}(),function(){s.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"===typeof window)return window}}()}(),function(){s.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)}}(),function(){s.p="/"}(),function(){var e={143:0};s.O.j=function(t){return 0===e[t]};var t=function(t,l){var n,a,r=l[0],o=l[1],i=l[2],c=0;if(r.some((function(t){return 0!==e[t]}))){for(n in o)s.o(o,n)&&(s.m[n]=o[n]);if(i)var u=i(s)}for(t&&t(l);c<r.length;c++)a=r[c],s.o(e,a)&&e[a]&&e[a][0](),e[a]=0;return s.O(u)},l=self["webpackChunke_kivotos"]=self["webpackChunke_kivotos"]||[];l.forEach(t.bind(null,0)),l.push=t.bind(null,l.push.bind(l))}();var l=s.O(void 0,[998],(function(){return s(3377)}));l=s.O(l)})();
//# sourceMappingURL=app.f48a5b9b.js.map