<!--
  행사 상세 정보 페이지
  Last Update: 25.06.12
-->

<template>
  <div class="max-w-5xl mx-auto text-center" v-if="eventDetails">
    <p class="p-4 text-lg font-bold">
      {{ eventDetails.description }}
    </p>
    <p class="text-3xl font-bold" >
      {{ eventDetails.title }}
    </p>
    <div class="pt-6 flex gap-4">
      <img :src=imagePath :alt="`${eventDetails.eventId}`" width="300px" />
      <div class="text-left text-lg flex flex-col gap-2">
        <p>
          행사기간: {{ eventDetails.startDate }} ~ {{ eventDetails.endDate }}
        </p>
        <p>
          장소: {{ eventDetails.place }}
        </p>
        <p>
          금액: 무료
        </p>
        <p>
          주최자: {{ eventDetails.organizer }}
        </p>
        <p>
          전화번호: 02-1111-1111
        </p>
      </div>
    </div>
    <button
        type="button"
        class="mt-4 bg-[#569AFF] px-4 py-2 rounded-md cursor-pointer hover:bg-[#4383e0] transition text-white"
        @click="goMakeCompanion"
    >
      바로 일정 잡기
    </button>
  </div>
  <div v-else>
    <p>이벤트 정보를 불러오는 중입니다...</p>
  </div>
</template>
<script setup lang="ts">
import {computed, onMounted, ref} from 'vue'
import {useRoute, useRouter} from 'vue-router'
import axiosInstance from '../lib/axios'
import type { EventDetailInfo } from "../types/types.ts"
import {useEventStore} from "../store/useEventStore.ts";

const eventStore = useEventStore()

const route = useRoute()
const eventId = ref<number>(Number(route.params.id))

const eventDetails = ref<EventDetailInfo | null>(null)

const imagePath = computed(() => {
  return new URL(`../assets/cardimg/${eventId.value}.png`, import.meta.url).href;
});

onMounted(async () => {
  try {
    const token = localStorage.getItem('token');

    const res = await axiosInstance.get(`/api/events/${eventId.value}`,
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        })
    console.log(res.data)
    eventDetails.value = res.data
  } catch (err) {
    console.error('이벤트 상세 정보 불러오기 실패', err)
  }
})

const router = useRouter()

function goMakeCompanion() {
  if (eventDetails.value) {
    eventStore.setEvent(eventDetails.value)
    router.push({ name: 'MakeCompanion', params: { id: eventId.value } })
  }
}

</script>