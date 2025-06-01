<script setup lang="ts">
</script>

<template>
  <div class="max-w-5xl">
    <p class="p-4 text-center text-2xl font-bold">함께하는 행사,<br/>WITHUS와 시작하세요</p>
    <div class="mt-12 w-xl grid grid-cols-1 gap-6 text-sm">
      <div>
        <label for="identify" class="block mb-1">아이디(이메일)</label>
        <input id="identify" type="email" class="p-4 w-full border border-gray-300 rounded-md" placeholder="E-mail을 입력해주세요."/>
      </div>
      <div>
        <label for="password" class="block mb-1">비밀번호</label>
        <input id="password" type="password" class="p-4 w-full border border-gray-300 rounded-md" placeholder="비밀번호를 입력해주세요."/>
      </div>
      <button
          type="button"
          class="mt-2 bg-[#569AFF] py-4 rounded-lg cursor-pointer hover:bg-sky-500 transition text-white"
      >
        로그인
      </button>
      <ul class="flex justify-center divide-x text-gray-500 divide-gray-200">
        <li class="px-4"><RouterLink to="">아이디찾기</RouterLink></li>
        <li class="px-4"><RouterLink to="">비밀번호 찾기</RouterLink></li>
        <li class="px-4 text-[#569AFF]"><RouterLink to="Signup">회원가입</RouterLink></li>
      </ul>
    </div>
  </div>
</template>

<style scoped>

</style>