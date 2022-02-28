package practice.spring.service

import practice.spring.domain.Member
import practice.spring.repository.MemberRepository

class MemberService(
    private val memberRepository: MemberRepository
) {
    fun signup(member: Member) = member
        .run {
            checkDuplicateMember(member)
            memberRepository.save(member)
            id
        }

    private fun checkDuplicateMember(member: Member) = memberRepository.findByName(member.name)
        ?.run { throw IllegalStateException("이미 존재하는 회원입니다.") }

    fun findAllMembers() = memberRepository.findAll()

    fun findMember(memberId: Long) = memberRepository.findById(memberId)
        ?.run { throw IllegalStateException("존재하지 않는 회원입니다.") }
}
