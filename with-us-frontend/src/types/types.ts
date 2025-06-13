/*
* Type 정의
* Last Update: 25.06.12
* */

export type EventDetailInfo = {
    title: string
    eventId: number
    place: string
    startDate: Date
    endDate: Date
    description: string
    organizer: string
}

export type EventInfo = {
    eventId: number,
    title: string,
    startDate: Date,
    endDate: Date,
    place: string,
}

export type GroupRecruitInfo = {
    eventId: number,
    title: string,
    description: string,
    maxParticipants: number,
    meetingPlace: string,
    recruitmentDeadline: string
}

export type ExtendsGroupRecruitInfo = GroupRecruitInfo & {
    recruitmentId: number,
    authorId: number,
    currentParticipants: number,
    status: string,
}