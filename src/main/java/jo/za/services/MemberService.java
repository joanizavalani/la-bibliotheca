package jo.za.services;

import jo.za.entities.Member;
import jo.za.repositories.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){

        this.memberRepository = memberRepository;
    }

    // methods for registering new members

    public Member registerMember(Member member){

        return this.memberRepository.save(member);
    }

    public List<Member> registerListOfMembers(List<Member> members){

        return this.memberRepository.saveAll(members);
    }

    // remove a member

    public void removeMember(long id){

        this.memberRepository.deleteById(id);
    }

    // to do: finish the rest of this class
}
