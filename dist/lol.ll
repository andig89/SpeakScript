@.format_str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(i8*, ...) nounwind
define i32 @main() nounwind {
%b = alloca i32, align 4
%1 = add i32 0, 23
store i32 %1, i32* %b, align 4
%2 = load i32* %b
%3 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([4 x i8]* @.format_str, i32 0, i32 0), i32 %2) nounwind
%a = alloca i32, align 4
%4 = add i32 0, 2
store i32 %4, i32* %a, align 4
%5 = load i32* %a
%6 = call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([4 x i8]* @.format_str, i32 0, i32 0), i32 %5) nounwind
ret i32 0
}

