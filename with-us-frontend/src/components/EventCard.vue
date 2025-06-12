<!--
  행사 카드 컴포넌트
  Last Update: 25.06.12
-->
<template>
  <div class="w-76 h-auto cursor-pointer" @click="goToEventDetail">
    <!-- 이미지 경로를 DB에 저장하는 방법 고려  -->
    <img :src="`src/assets/cardimg/${event.eventId}.png`" :alt="`${event.title}`"/>
    <div class="p-1">
      <p class="text-lg font-bold">{{ event.title }}</p>
      <p class="text-sm">{{ event.startDate }} ~ {{ event.endDate }}</p>
      <p class="text-sm">{{ event.place }}</p>
    </div>
  </div>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router'

const props = defineProps<{
  event: {
    eventId: number
    title: string
    startDate: string
    endDate: string
    place: string
  }
}>()

const router = useRouter()

function goToEventDetail() {
  router.push({ name: 'EventDetail', params: { id: props.event.eventId } })
}
</script>