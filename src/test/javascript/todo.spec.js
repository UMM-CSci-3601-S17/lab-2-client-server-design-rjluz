/**
 * Created by lopez477 on 2/1/17.
 */
describe('testing todo functions', function(){
    it('should return the correct url for the category specification', function(){
    expect(buildCategoryURL("groceries")).toBe("/api/todos?category=groceries");
    });

    it('should return the correct url for the owner specification', function(){
    expect(buildOwnerURL("Blanche")).toBe("/api/todos?owner=Blanche");
    });

    it('should return the correct url for the contains specification', function(){
    expect(buildContainsURL("to")).toBe("/api/todos?contains=to");
    });

    it('should return the correct url for the status specification', function(){
    expect(buildStatusURL("complete")).toBe("/api/todos?status=complete");
    });

    it('should return the correct url for the limit specification', function(){
    expect(buildLimitURL("2")).toBe("/api/todos?limit=2");
    });

    it('should return the correct url for the ID specification', function(){
    expect(buildIdURL("58895985a22c04e761776d54")).toBe("/api/todos/58895985a22c04e761776d54");
    });


});

