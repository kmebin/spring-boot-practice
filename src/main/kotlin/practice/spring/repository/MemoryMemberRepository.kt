package practice.spring.repository

import practice.spring.domain.Member

class MemoryMemberRepository : MemberRepository {

    override fun add(member: Member): Member {
        member.id = ++sequence
        store[member.id] = member

        return member
    }

    override fun findById(id: Long): Member? {
        return store[id]
    }

    override fun findByName(name: String): Member? {
        return store.values.find { it.name == name }
    }

    override fun findAll(): List<Member> {
        return ArrayList(store.values)
    }

    fun clear() {
        store.clear()
    }

    companion object {
        private val store: MutableMap<Long, Member> = HashMap()
        private var sequence = 0L
    }
}
