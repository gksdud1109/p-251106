package com.back.domain.member.member.repository

import com.back.domain.member.member.entity.Member

interface MemberRepositoryCustom {
    fun findQById(id: Long): Member?
    fun findQByUsername(username: String): Member?
    fun findQByIdIn(ids: List<Long>): List<Member>
}