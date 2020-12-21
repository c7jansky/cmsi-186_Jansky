@echo off
@del testresults.txt
@javac BirthdaySolver.java

REM ============================================================================
REM filename: birthdaytests.bat
REM purpose: provide a unified test sequence for the BirthdaySolver Project
REM @see http://bjohnson.lmu.build/cmsi186web/homework07.html for details
REM NOTE:  because this is a windows batch file and there is no convenient "tee"
REM   filter program, we are forced to do this the ugly way by repeating all
REM   the sections twice, once to the command window and once to the output file
REM NOTE:  lines that begin with "@" will echo to the command window
REM         those that don't will be appended to the 'testresults.txt' file
REM NOTE:  the doubled percent signs are to ensure that the '%' prints
REM ============================================================================

@echo =====================================================
@echo Testing the BirthdaySolver Project Homework # 07
@echo =====================================================
echo =====================================================                             >> testresults.txt
echo Testing the BirthdaySolver Project Homework # 07                                 >> testresults.txt
echo =====================================================                             >> testresults.txt

@echo .
@echo =============================================================================
@echo TEST #1
@echo ... checking running with no arguments on command line
@echo ...   should either throw exceptions which will not appear in the output file
@echo ...     but which should be caught to keep the test program running
@echo ...   or preferably output error messages which SHOULD appear there then quit
@echo =============================================================================
@java BirthdaySolver
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #1                                                                           >> testresults.txt
echo ... checking running with no arguments on command line                            >> testresults.txt
echo ...   should either throw exceptions which will not appear in the output file     >> testresults.txt
echo ...     but which should be caught to keep the test program running               >> testresults.txt
echo ...   or preferably output error messages which SHOULD appear there then quit     >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver                                                                   >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #2
@echo ... checking running with bogus argument value on command line
@echo ...   should either throw exceptions which will not appear in the output file
@echo ...     but which should be caught to keep the test program running
@echo ...   or preferably output error messages which SHOULD appear there then quit
@echo =============================================================================
@java BirthdaySolver a
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #2                                                                           >> testresults.txt
echo ... checking running with bogus argument value on command line                    >> testresults.txt
echo ...   should either throw exceptions which will not appear in the output file     >> testresults.txt
echo ...     but which should be caught to keep the test program running               >> testresults.txt
echo ...   or preferably output error messages which SHOULD appear there then quit     >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver a                                                                 >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #3
@echo ... checking running with one arguments to check default # experiments
@echo ...   should produce valid outputs of about 100%%
@echo =============================================================================
@java BirthdaySolver 100
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #3                                                                           >> testresults.txt
echo ... checking running with one arguments to check default # experiments            >> testresults.txt
echo ...   should produce valid outputs of about 100%%                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 100                                                               >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #4
@echo ... checking running with two arguments to check commanded # experiments
@echo ...   should produce valid outputs of 100%%
@echo =============================================================================
@java BirthdaySolver 100 10000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #4                                                                           >> testresults.txt
echo ... checking running with one arguments to check commanded # experiments          >> testresults.txt
echo ...   should produce valid outputs of 100%%                                       >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 100 10000                                                         >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #5
@echo ... checking running with two arguments to check person count > 365
@echo ...   should produce valid outputs of 100%%
@echo =============================================================================
@java BirthdaySolver 366 10000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #5                                                                           >> testresults.txt
echo ... checking running with one arguments to check person count > 365               >> testresults.txt
echo ...   should produce valid outputs of 100%%                                       >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 366 10000                                                         >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #6
@echo ... checking running with two arguments: 75 people and 10,000 trials
@echo ...   should produce valid outputs of 99.99%%
@echo =============================================================================
@java BirthdaySolver 75 10000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #6                                                                           >> testresults.txt
echo ... checking running with one arguments: 75 people and 10,000 trials              >> testresults.txt
echo ...   should produce valid outputs of 99.99%%                                     >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 75 10000                                                          >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #7
@echo ... checking running with two arguments: 50 people and 10,000 trials
@echo ...   should produce valid outputs of 97.04%%
@echo =============================================================================
@java BirthdaySolver 50 10000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #7                                                                           >> testresults.txt
echo ... checking running with one arguments: 50 people and 10,000 trials              >> testresults.txt
echo ...   should produce valid outputs of 97.04%%                                     >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 50 10000                                                          >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #8
@echo ... checking running with two arguments: 25 people and 1,000 trials
@echo ...   should produce valid outputs of 56.87%%
@echo =============================================================================
@java BirthdaySolver 25 10000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #8                                                                           >> testresults.txt
echo ... checking running with one arguments: 25 people and 1,000 trials               >> testresults.txt
echo ...   should produce valid outputs of 56.87%%                                     >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 25 10000                                                          >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #9
@echo ... checking running with two arguments: 10 people and 1,000,000 trials
@echo ...   should produce valid outputs of 11.69%%
@echo =============================================================================
@java BirthdaySolver 10 1000000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #9                                                                           >> testresults.txt
echo ... checking running with one arguments: 10 people and 1,000,000 trials           >> testresults.txt
echo ...   should produce valid outputs of 11.69%%                                     >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 10 1000000                                                        >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #10
@echo ... checking running with two arguments: 30 people and 10,000,000 trials
@echo ...   should produce valid outputs of 70.63%%
@echo ...   should also get message that 'this will take a while'
@echo =============================================================================
@java BirthdaySolver 30 10000000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #10                                                                          >> testresults.txt
echo ... checking running with one arguments: 30 people and 10,000,000 trials          >> testresults.txt
echo ...   should produce valid outputs of 70.63%%                                     >> testresults.txt
echo ...   should also get message that 'this will take a while'                       >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 30 10000000                                                     >> testresults.txt

@echo .
@echo =============================================================================
@echo TEST #11
@echo ... checking running with bogus second argument on command line
@echo ...   should either throw exceptions which will not appear in the output file
@echo ...     but which should be caught to keep the test program running
@echo ...   or preferably output error messages which SHOULD appear there then quit
@echo =============================================================================
@java BirthdaySolver 100 wtf
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #11                                                                          >> testresults.txt
echo ... checking running with bogus second argument on command line                   >> testresults.txt
echo ...   should either throw exceptions which will not appear in the output file     >> testresults.txt
echo ...     but which should be caught to keep the test program running               >> testresults.txt
echo ...   or preferably output error messages which SHOULD appear there then quit     >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver  100 wtf                                                          >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #12
@echo ... checking running with two bogus argument values on command line
@echo ...   should either throw exceptions which will not appear in the output file
@echo ...     but which should be caught to keep the test program running
@echo ...   or preferably output error messages which SHOULD appear there then quit
@echo =============================================================================
@java BirthdaySolver a b
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #12                                                                          >> testresults.txt
echo ... checking running with two bogus argument values on command line               >> testresults.txt
echo ...   should either throw exceptions which will not appear in the output file     >> testresults.txt
echo ...     but which should be caught to keep the test program running               >> testresults.txt
echo ...   or preferably output error messages which SHOULD appear there then quit     >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver a b                                                               >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #13
@echo ... checking running with one arguments to check default # experiments
@echo ...   should produce valid outputs of about 100%%
@echo =============================================================================
@java BirthdaySolver 83
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #13                                                                          >> testresults.txt
echo ... checking running with one arguments to check default # experiments            >> testresults.txt
echo ...   should produce valid outputs of about 100%%                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 83                                                                >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #14
@echo ... checking running with two arguments to check commanded # experiments
@echo ...   should produce valid outputs of 100%%
@echo =============================================================================
@java BirthdaySolver 100 123456
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #14                                                                          >> testresults.txt
echo ... checking running with two arguments to check commanded # experiments          >> testresults.txt
echo ...   should produce valid outputs of 100%%                                       >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 100 123456                                                        >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #15
@echo ... checking running with two arguments to check person count == 365
@echo ...   should produce valid outputs of 100%%
@echo =============================================================================
@java BirthdaySolver 365 10000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #15                                                                          >> testresults.txt
echo ... checking running with one arguments to check person count == 365              >> testresults.txt
echo ...   should produce valid outputs of 100%%                                       >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 365 10000                                                         >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #16
@echo ... checking running with two arguments: 77 people and 10,000 trials
@echo ...   should produce valid outputs of 99.99%%
@echo =============================================================================
@java BirthdaySolver 77 10000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #16                                                                          >> testresults.txt
echo ... checking running with one arguments: 77 people and 10,000 trials              >> testresults.txt
echo ...   should produce valid outputs of 99.99%%                                     >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 77 10000                                                          >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #17
@echo ... checking running with two arguments: 37 people and 10,000 trials
@echo ...   should produce valid outputs of 84.87%%
@echo =============================================================================
@java BirthdaySolver 37 10000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #17                                                                          >> testresults.txt
echo ... checking running with one arguments: 37 people and 10,000 trials              >> testresults.txt
echo ...   should produce valid outputs of 84.87%%                                     >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 37 10000                                                          >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #18
@echo ... checking running with two arguments: 37 people and 1,000 trials
@echo ...   should produce valid outputs of 84.87%%
@echo =============================================================================
@java BirthdaySolver 37 1000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #18                                                                          >> testresults.txt
echo ... checking running with one arguments: 37 people and 1,000 trials               >> testresults.txt
echo ...   should produce valid outputs of 84.87%%                                     >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 37 1000                                                           >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #19
@echo ... checking running with two arguments: 37 people and 1,000,000 trials
@echo ...   should produce valid outputs of 84.87%%
@echo =============================================================================
@java BirthdaySolver 37 1000000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #19                                                                          >> testresults.txt
echo ... checking running with one arguments: 37 people and 1,000,000 trials           >> testresults.txt
echo ...   should produce valid outputs of 84.87%%                                     >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 37 1000000                                                        >> testresults.txt

@echo .
@echo .
@echo =============================================================================
@echo TEST #20
@echo ... checking running with two arguments: 37 people and 1,000,000 trials
@echo ...   should produce valid outputs of 84.87%%
@echo ...   should also get message that 'this will take a while'
@echo =============================================================================
@java BirthdaySolver 37 1000000
echo .                                                                                 >> testresults.txt
echo .                                                                                 >> testresults.txt
echo =============================================================================     >> testresults.txt
echo TEST #20                                                                          >> testresults.txt
echo ... checking running with one arguments: 37 people and 1,000,000 trials           >> testresults.txt
echo ...   should produce valid outputs of 84.87%%                                     >> testresults.txt
echo ...   should also get message that 'this will take a while'                       >> testresults.txt
echo =============================================================================     >> testresults.txt
java BirthdaySolver 37 1000000                                                        >> testresults.txt

@echo =====================================================
@echo Testing for Homework # 07 COMPLETED!
@echo =====================================================
echo =====================================================                             >> testresults.txt
echo Testing for Homework # 07 COMPLETED!                                              >> testresults.txt
echo =====================================================                             >> testresults.txt

