package practice.spring.repository

import practice.spring.domain.Member

class MemoryMemberRepository(
    private val store: MutableMap<Long, Member> = HashMap(),
    private var sequence: Long = 0L
) : MemberRepository {

    override fun save(member: Member) = member
        .apply {
            id = ++sequence
            store[id] = member
        }

    override fun findById(id: Long) = store[id]

    override fun findByName(name: String) = store.values.find { it.name == name }

    override fun findAll() = ArrayList(store.values)

    fun clear() = store.clear()
}
