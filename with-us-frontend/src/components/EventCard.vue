<template>
  <div class="w-76 h-auto cursor-pointer" @click="goToMakeCompanion">
    <img src="../assets/cardimg/1.png" alt="1" />
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

function goToMakeCompanion() {
  router.push({ name: 'Making', params: { id: props.event.eventId } })
}
</script>