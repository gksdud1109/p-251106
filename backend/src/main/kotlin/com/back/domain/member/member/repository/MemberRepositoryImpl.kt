package com.back.domain.member.member.repository

import com.back.domain.member.member.entity.Member
import com.back.domain.member.member.entity.QMember
import com.querydsl.jpa.impl.JPAQueryFactory

class MemberRepositoryImpl(
    private val jpaQuery: JPAQueryFactory
): MemberRepositoryCustom {
    override fun findQById(id: Long): Member? {
        val member = QMember.member

        return jpaQuery
            .selectFrom(member)
            .where(member.id.eq(id)) // where member.id = id
            .fetchOne() // limit 1
    }

    override fun findQByUsername(username: String): Member? {
        val member = QMember.member

        return jpaQuery
            .selectFrom(member)
            .where(member.username.eq(username))
            .fetchOne()
    }

    override fun findQByIdIn(ids: List<Long>): List<Member> {
        val member = QMember.member

        return jpaQuery
            .selectFrom(member)
            .where(member.id.`in`(ids)) // kotlin in 키워드랑도 겹쳐서 `in` 으로 사용
            .fetch()
    }
}