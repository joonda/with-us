<template>
  <div class="max-w-5xl">
    <p class="p-4 text-center text-3xl font-bold">행사 목록</p>
    <ul class="grid grid-cols-3 gap-x-10 gap-y-6">
      <!--
        TODO: 추후 RouterLink로 id별로 이동하도록 구현.
      -->
      <li><EventCard /></li>
      <li><EventCard /></li>
      <li><EventCard /></li>
      <li><EventCard /></li>
    </ul>
  </div>

</template>
<script setup lang="ts">

import EventCard from "../components/EventCard.vue";
</script>
<style scoped>

</style>