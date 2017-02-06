/**
 * Created by lopez477 on 2/1/17.
 */
describe('testing todo functions', function(){
    it('should return the correct ID', function(){
        expect(testStringLength("kittens")).toEqual(7);
    });

    it('returnKittens should return kittens', function(){
        expect(returnKittens()).toBe("kittens");
    });

    ////this test should fail.
    it('this test should fail!', function(){
        expect(returnKittens()).toBe("Not Kittens!");
    });
});

