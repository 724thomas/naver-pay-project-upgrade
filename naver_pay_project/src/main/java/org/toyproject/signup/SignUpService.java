package org.toyproject.signup;

public class SignUpService {

    private static SignUpService signUpService=null;

    public SignUpService(){}

    public static SignUpService getInstance(){
        if (signUpService==null){
            signUpService=new SignUpService();
        }
        return signUpService;
    }

    public UserDTO getUserInfo(String userId, String userPassword){
        UserDAO aDAO = UserDAO.getInstance();
        UserEntity theEntity = aDAO.searchUser(userId,userPassword);
        if (theEntity!=null){
            String id=theEntity.getUserId();
            String pw=theEntity.getUserPassword();
            String name = theEntity.getUserName();
            String phone= theEntity.getUserPhone();
            int point = theEntity.getUserPoint();
            UserDTO theDTO = new UserDTO(id,pw,name,phone,point);
            return theDTO;
        }else{
            return null;
        }
    }

    public void userSignUp(UserDTO theDTO){
        SignUpService aService = SignUpService.getInstance();
        //유저가 없으면
        if(aService.getUserInfo(theDTO.getUserId(), theDTO.getUserPassword())==null){
            UserDAO aDao = UserDAO.getInstance();
            String id=theDTO.getUserId();
            String pw=theDTO.getUserPassword();
            String name = theDTO.getUserName();
            String phone= theDTO.getUserPhone();
            int point = theDTO.getUserPoint();
            UserEntity theEntity = new UserEntity(id,pw,name,phone,point);
            aDao.insertUser(theEntity);
        }else{
            System.out.println("User already Exists");
        }
    }
}
