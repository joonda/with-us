<template>
  <div class="max-w-5xl">
    <div class="relative  w-full h-[360px]">
      <img
          src="../assets/bg.png"
          alt="background"
          class="w-full h-full object-cover shadow-[inset_-200px_0_100px_rgba(0,0,0,0.7)] rounded-xl"
      >
      <div
        class="absolute top-18 left-20 text-white"
      >
        <p class="text-4xl font-bold">누군가와 함께할 때, <br /> 더 특별해져요</p>
        <p class="mt-4">처음 가는 행사도, 덜 어색할 수 있어요. <br />
          혼자 고민하지 말고, 함께 갈 사람을 찾아보세요. <br />
          같이행이 그 시작을 도와줄게요.</p>
        <button
            type="button"
            class="mt-4 bg-[#569AFF] px-4 py-2 rounded-md cursor-pointer hover:bg-[#4383e0] transition"
            @click="goFindEvents"
        >
          바로 행사 찾기
        </button>
      </div>
    </div>
    <p class="p-4 text-center text-3xl font-bold">이달의 추천 문화 행사</p>
    <ul class="grid grid-cols-3 gap-x-10 gap-y-6">
      <li><EventCard /></li>
      <li><EventCard /></li>
      <li><EventCard /></li>
      <li><EventCard /></li>
    </ul>
  </div>

</template>

<script setup lang="ts">
import EventCard from "../components/EventCard.vue";
import {useRouter} from "vue-router";
const router = useRouter();

function goFindEvents() {
  router.push("/events");
}
</script>

<style scoped>

</style>