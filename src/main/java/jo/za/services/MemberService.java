package jo.za.services;

import jo.za.entities.Member;
import jo.za.repositories.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    // get methods

    public List<Member> getAllMembers(){

        return this.memberRepository.findAll();
    }

    public Member getMemberById(long id){

        return this.memberRepository.findById(id).get();
    }

    public List<Member> getMembersByRentingStatus(boolean isRenting){

        List<Member> allMembers = getAllMembers();
        List<Member> membersByRentingStatus = new ArrayList<>();

        for(Member member : allMembers){

            if(member.isRenting() == isRenting){

                membersByRentingStatus.add(member);
            }
        }

        return membersByRentingStatus;
    }
}
