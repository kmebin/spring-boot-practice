package practice.spring.repository

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import practice.spring.domain.Member

class MemoryMemberRepositoryTest {

    private val repository = MemoryMemberRepository()

    @AfterEach
    fun clear() = repository.clear()

    @Test
    fun save() {
        val member = Member(name = "spring")

        repository.save(member)

        val result = repository.findById(member.id)

        assertThat(member).isEqualTo(result)
    }

    @Test
    fun findByName() {
        val member1 = Member(name = "spring1")
        val member2 = Member(name = "spring2")

        repository.save(member1)
        repository.save(member2)

        val result = repository.findByName("spring1")

        assertThat(result).isEqualTo(member1)
    }

    @Test
    fun findAll() {
        val member1 = Member(name = "spring1")
        val member2 = Member(name = "spring2")

        repository.save(member1)
        repository.save(member2)

        val result = repository.findAll()

        assertThat(result.size).isEqualTo(2)
    }
}
