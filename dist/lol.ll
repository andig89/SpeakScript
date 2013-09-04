@.scanf_string = private unnamed_addr constant [3 x i8] c"%s\00", align 1
@.printf_int = private unnamed_addr constant [5 x i8] c"%i \0A\00", align 1
@.printf_double = private unnamed_addr constant [5 x i8] c"%f \0A\00", align 1
@.printf_string = private unnamed_addr constant [5 x i8] c"%s \0A\00", align 1



define i32 @main() nounwind {
%scanf.string = alloca [1009 x i8], align 1
%a.string = alloca [1009 x i8], align 1
%d.string = alloca [1009 x i8], align 1
%b.int = alloca i32, align 4
%a.int = alloca i32, align 4
%c.int = alloca i32, align 4
%d.int = alloca i32, align 4
%d.double = alloca double, align 8
%a.type = alloca i32, align 4
%d.type = alloca i32, align 4
%a.double = alloca double, align 8
store i32 12, i32* %b.int, align 4
store i32 2, i32* %a.int, align 4
store i32 1, i32* %a.int, align 4
store i32 26, i32* %c.int, align 4
store i32 3, i32* %d.int, align 4
store double 4.1, double* %d.double, align 8
%1 = getelementptr inbounds [1009 x i8]* %scanf.string, i32 0, i32 0
%2 = call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3 x i8]* @.scanf_string, i32 0, i32 0), i8* %1)
%3 = getelementptr inbounds [1009 x i8]* %scanf.string, i32 0, i32 0
%4 = call zeroext i1 @IsDigital(i8* %3)
br i1 %4, label %5, label %12

; <label>:5
%6 = call double @atof(i8* %3)
%7 = call double @fmod(double %6, double 1.000000e+00)
%8 = fcmp oeq double %7, 0.000000e+00
br i1 %8, label %9, label %11

; <label>:9
%10 = fptosi double %6 to i32
store i32 %10, i32* %a.int, align 4
store i32 1, i32* %a.type, align 4
br label %15

; <label>:11
store double %6, double* %a.double, align 8
store i32 2, i32* %a.type, align 4
br label %15

; <label>:12
%13 = getelementptr inbounds [1009 x i8]* %a.string, i32 0, i32 0
%14 = call i8* @strcpy(i8* %13, i8* %3)
store i32 3, i32* %a.type, align 4
br label %15

; <label>:15
%16 = getelementptr inbounds [1009 x i8]* %scanf.string, i32 0, i32 0
%17 = call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3 x i8]* @.scanf_string, i32 0, i32 0), i8* %16)
%18 = getelementptr inbounds [1009 x i8]* %scanf.string, i32 0, i32 0
%19 = call zeroext i1 @IsDigital(i8* %18)
br i1 %19, label %20, label %27

; <label>:20
%21 = call double @atof(i8* %18)
%22 = call double @fmod(double %21, double 1.000000e+00)
%23 = fcmp oeq double %22, 0.000000e+00
br i1 %23, label %24, label %26

; <label>:24
%25 = fptosi double %21 to i32
store i32 %25, i32* %d.int, align 4
store i32 1, i32* %d.type, align 4
br label %30

; <label>:26
store double %21, double* %d.double, align 8
store i32 2, i32* %d.type, align 4
br label %30

; <label>:27
%28 = getelementptr inbounds [1009 x i8]* %d.string, i32 0, i32 0
%29 = call i8* @strcpy(i8* %28, i8* %18)
store i32 3, i32* %d.type, align 4
br label %30

; <label>:30
%31 = load i32* %a.type, align 4
%32 = icmp eq i32 %31, 1
br i1 %32, label %33, label %36

; <label>:33
%34 = load i32* %a.int, align 4
%35 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_int, i32 0, i32 0), i32 %34)
br label %44

; <label>:36
%37 = icmp eq i32 %31, 2
br i1 %37, label %38, label %41

; <label>:38
%39 = load double* %a.double, align 8
%40 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_double, i32 0, i32 0), double %39)
br label %44

; <label>:41
%42 = getelementptr inbounds [1009 x i8]* %a.string, i32 0, i32 0
%43 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_string, i32 0, i32 0), i8* %42)
br label %44

; <label>:44
%45 = load i32* %b.int, align 4
%46 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_int, i32 0, i32 0), i32 %45)
%47 = load i32* %c.int, align 4
%48 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_int, i32 0, i32 0), i32 %47)
%49 = getelementptr inbounds [1009 x i8]* %scanf.string, i32 0, i32 0
%50 = call i32 (i8*, ...)* @scanf(i8* getelementptr inbounds ([3 x i8]* @.scanf_string, i32 0, i32 0), i8* %49)
%51 = getelementptr inbounds [1009 x i8]* %scanf.string, i32 0, i32 0
%52 = call zeroext i1 @IsDigital(i8* %51)
br i1 %52, label %53, label %60

; <label>:53
%54 = call double @atof(i8* %51)
%55 = call double @fmod(double %54, double 1.000000e+00)
%56 = fcmp oeq double %55, 0.000000e+00
br i1 %56, label %57, label %59

; <label>:57
%58 = fptosi double %54 to i32
store i32 %58, i32* %d.int, align 4
store i32 1, i32* %d.type, align 4
br label %63

; <label>:59
store double %54, double* %d.double, align 8
store i32 2, i32* %d.type, align 4
br label %63

; <label>:60
%61 = getelementptr inbounds [1009 x i8]* %d.string, i32 0, i32 0
%62 = call i8* @strcpy(i8* %61, i8* %51)
store i32 3, i32* %d.type, align 4
br label %63

; <label>:63
%64 = load i32* %d.type, align 4
%65 = icmp eq i32 %64, 1
br i1 %65, label %66, label %69

; <label>:66
%67 = load i32* %d.int, align 4
%68 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_int, i32 0, i32 0), i32 %67)
br label %77

; <label>:69
%70 = icmp eq i32 %64, 2
br i1 %70, label %71, label %74

; <label>:71
%72 = load double* %d.double, align 8
%73 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_double, i32 0, i32 0), double %72)
br label %77

; <label>:74
%75 = getelementptr inbounds [1009 x i8]* %d.string, i32 0, i32 0
%76 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.printf_string, i32 0, i32 0), i8* %75)
br label %77

; <label>:77
ret i32 0
}

define zeroext i1 @IsDigital(i8* %ciagZnakow) nounwind {
%charEnd = alloca i8*, align 8
%1 = alloca i8*, align 8
store i8* %ciagZnakow, i8** %1, align 8
%2 = load i8** %1, align 8
%3 = call x86_fp80 @strtold(i8* %2, i8** %charEnd)
%4 = load i8** %charEnd, align 8
%5 = load i8* %4, align 1
%6 = sext i8 %5 to i32
%7 = icmp eq i32 %6, 0
ret i1 %7
}

declare i32 @scanf(i8*, ...)
declare x86_fp80 @strtold(i8*, i8**)
declare double @atof(i8*)
declare double @fmod(double, double)
declare i8* @strcpy(i8*, i8*)
declare i32 @printf(i8*, ...)

