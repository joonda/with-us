/*
* 행사 상세정보 저장
* Last Update: 25.06.12
* */

import {defineStore} from "pinia";
import type {EventDetailInfo} from "../types/types.ts"

export const useEventStore = defineStore('event', {
    state: () => ({
        selectedEvent: null as EventDetailInfo | null,
    }),
    actions: {
        setEvent(event: EventDetailInfo) {
            this.selectedEvent = event
        },
        clearEvent() {
            this.selectedEvent = null
        }
    },
})