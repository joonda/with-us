<!--
  동행 만들기 페이지
  Last Update: 25.06.12
-->

<template>
  <div class="w-full max-w-3xl mx-auto p-4">
    <h1 class="text-2xl mb-4"><span class="font-bold">{{ eventDetail?.title }}</span> 동행 만들기</h1>
    <!-- 제목 -->
    <div class="mb-4">
      <label class="block font-semibold mb-1">제목</label>
      <input v-model="recruitForm.title" type="text" class="w-full border rounded p-2" placeholder="제목을 입력하세요" />
    </div>

    <!-- 설명 -->
    <div class="mb-4">
      <label class="block font-semibold mb-1">설명</label>
      <textarea v-model="recruitForm.description" class="w-full border rounded p-2" rows="4" placeholder="어떤 동행인지 설명해 주세요"></textarea>
    </div>

    <div class="flex gap-4">
      <!-- 모집 마감일 -->
      <div class="mb-4">
        <label class="block font-semibold mb-1">모집 마감일</label>
        <input v-model="recruitForm.recruitmentDeadline" type="date" class="w-full border rounded p-2" />
      </div>

      <!-- 최대 인원 -->
      <div class="mb-4">
        <label class="block font-semibold mb-1">최대 인원</label>
        <select v-model="recruitForm.maxParticipants" class="border rounded p-2">
          <option value=2>2</option>
          <option value=3>3</option>
          <option value=4>4</option>
          <option value=5>5</option>
          <option value=6>6</option>
        </select>
      </div>
    </div>

    <!-- 만남 장소 -->
    <div class="mb-4">
      <label class="block font-semibold mb-1">만남 장소</label>
      <input v-model="recruitForm.meetingPlace" type="text" class="w-full border rounded p-2" />
    </div>

    <!-- 제출 버튼 -->
    <button @click="save" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">
      동행 모집 등록
    </button>
  </div>
</template>
<script setup lang="ts">
import { useEventStore } from "../store/useEventStore"
import axiosInstance from "../lib/axios.ts";
import type {GroupRecruitInfo} from "../types/types.ts"
import {reactive, ref} from "vue";
import {useRoute, useRouter} from "vue-router";

const route = useRoute()
const router = useRouter()
const eventId = ref<number>(Number(route.params.id))

const eventStore = useEventStore()
const eventDetail = eventStore.selectedEvent

const today = new Date();
const deadlineDate = today.toISOString().slice(0, 10); // "2025-06-12"

const recruitForm = reactive<GroupRecruitInfo>({
  eventId: eventId.value,
  title: '',
  description: '',
  maxParticipants: 2,
  meetingPlace: '',
  recruitmentDeadline: deadlineDate
})

async function save() {
  try {
    const res = await axiosInstance.post('/api/groupRecruit/save', recruitForm, {withCredentials: true})
    if (res.data.message) {
      alert(res.data.message)
      await router.push("/")
    }
  } catch (err) {
    console.error('이벤트 불러오기 실패', err)
  }
}

</script>