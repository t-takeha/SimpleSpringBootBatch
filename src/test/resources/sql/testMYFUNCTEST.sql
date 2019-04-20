declare
    RC NUMBER;
    OUT1 NUMBER(3);
    OUT2 VARCHAR2(200);
    PK VARCHAR2(20);
BEGIN
    -- PK採番
    SELECT TO_CHAR(SYSDATE, 'YYMMDDHHMISS') INTO PK FROM DUAL;

    -- キー重複に備えて消す
    DELETE FROM MYTBL WHERE id=PK;

    -- ストアード呼び出し
    RC := MYFUNCTEST(PK, OUT1, OUT2);
    DBMS_OUTPUT.put_line('------------ resutl ----------');
    DBMS_OUTPUT.put_line('RC = ' || to_char(RC));
    DBMS_OUTPUT.put_line(OUT1);
    DBMS_OUTPUT.put_line(OUT2);
    COMMIT;
END;
/

SELECT * from mytbl order by id;
