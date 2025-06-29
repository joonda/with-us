<!--
  ===========================================
  최초작성자    : 이현준
  최초작성일    : 25.06.09.
  수정자       : 이현준
  마지막 수정일 : 25.06.29.
  설명        : 동행 찾기 페이지
  수정내용     : 로그인 상태가 아닐 시, 강제로 login 화면으로 push 추가
  ===========================================
-->

<template>
  <div class="max-w-5xl mx-auto grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
    <div
        v-for="item in groupList"
        :key="item.eventId"
        class="max-w-sm bg-white border border-gray-200 rounded-lg shadow"
    >
      <img
          :src="getImagePath(item.eventId)"
          :alt="item.title"
          class="rounded-t-lg w-full h-48 object-cover"
      />
      <div class="p-5">
        <div class="inline-block rounded-2xl bg-gray-400 px-2 py-1 text-white text-sm">
          {{item.status}}
        </div>
        <h5 class="ml-1 my-2 text-2xl font-bold tracking-tight text-gray-900">{{ item.title }}</h5>
        <p class="ml-1 my-3 font-normal text-gray-700">{{ item.description }}</p>
        <button
            href="#"
            class="inline-flex items-center px-3 py-2 text-sm font-medium text-white bg-blue-600 rounded-lg hover:bg-blue-700"
        >
          상세 보기
        </button>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import axiosInstance from "../lib/axios.ts";
import type {ExtendsGroupRecruitInfo} from "../types/types.ts";
import {useRouter} from "vue-router";

const groupList = ref<ExtendsGroupRecruitInfo[]>([])
const router = useRouter()

onMounted(async () => {
  try {
    const token = localStorage.getItem('token');

    const res = await axiosInstance.get('/api/groupRecruit/list',
        { headers: {
          Authorization: `Bearer ${token}`
          } }
    )
    console.log(res.data)
    groupList.value = res.data
  } catch (err) {
    console.error('이벤트 불러오기 실패', err)
    await router.push('/login')
  }
})

const getImagePath = (eventId: number) => {
  try {
    return new URL(`../assets/cardimg/${eventId}.png`, import.meta.url).href;
  } catch {
    return new URL(`../assets/cardimg/default.png`, import.meta.url).href;
  }
}
</script>
<style scoped>

</style>