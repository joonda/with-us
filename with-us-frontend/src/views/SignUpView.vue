<template>
  <div>
    <p class="p-4 text-center text-2xl font-bold">회원가입</p>
    <div class="mt-12 w-lg grid grid-cols-1 gap-6 text-sm">
      <div>
        <label for="identify" class="block mb-1">아이디(이메일)</label>
        <div class="flex gap-2 justify-between">
          <input v-model="form.identify" id="identify" type="email" class="p-4 flex-1 border border-gray-300 rounded-md"
                 placeholder="example@withus.com"/>
          <button class="px-4 border border-[#569AFF] text-[#569AFF] rounded-md">
            중복확인
          </button>
        </div>
        <p class="mt-2 text-red-500">이메일 형식이 맞지 않습니다. 다시 입력해주세요</p>
      </div>
      <div>
        <label for="password" class="block mb-1">비밀번호</label>
        <input v-model="form.password" id="password" type="password"
               class="p-4 w-full border border-gray-300 rounded-md" placeholder="영문, 숫자, 특수문자 8~16자 이내"/>
      </div>
      <div>
        <label for="checkPassword" class="block mb-1">비밀번호 확인</label>
        <input id="checkPassword" type="password" class="p-4 w-full border border-gray-300 rounded-md"
               placeholder="확인을 위해 한번 더 입력해주세요."/>
      </div>
      <div>
        <label for="name" class="block mb-1">이름</label>
        <input v-model="form.name" id="name" type="text" class="p-4 w-full border border-gray-300 rounded-md"/>
      </div>
      <div>
        <label for="birthdate" class="block mb-1">생년월일</label>
        <div id="birthdate" class="flex gap-2">
          <select v-model="form.birthYear" class="px-4 py-2 w-full border rounded-md border-gray-300">
            <option value="">선택</option>
            <option>1995</option>
          </select>
          <select v-model="form.birthMonth" class="px-4 py-2 w-full border rounded-md border-gray-300">
            <option value="">선택</option>
          </select>
          <select v-model="form.birthDay" class="px-4 py-2 w-full border rounded-md border-gray-300">
            <option value="">선택</option>
          </select>
        </div>
      </div>
      <div>
        <label for="phone" class="block mb-1">휴대전화번호</label>
        <input v-model="form.phone" id="phone" type="text" class="p-4 w-full border border-gray-300 rounded-md"/>
      </div>
      <div>
        <label class="block mb-1">성별</label>
        <div class="flex gap-2">
          <input v-model="form.gender" type="radio" id="male" value="M" name="gender"/><label for="male">남성</label>
          <input v-model="form.gender" type="radio" id="female" value="F" name="gender"/><label for="female">여성</label>
        </div>
      </div>
      <button
          type="button"
          class="mt-2 bg-[#569AFF] py-4 rounded-lg cursor-pointer hover:bg-[#4383e0] transition text-white"
      >
        확인
      </button>
    </div>
  </div>
</template>

<script setup lang="ts">
import {reactive} from "vue";

interface SignUpForm {
  identify: string
  password: string
  name: string
  birthYear: string
  birthMonth: string
  birthDay: string
  phone: string
  gender: 'M' | 'F' | ''
}

const form = reactive<SignUpForm>({
  identify: '',
  password: '',
  name: '',
  birthYear: '',
  birthMonth: '',
  birthDay: '',
  phone: '',
  gender: ''
})
</script>

<style scoped>

</style>