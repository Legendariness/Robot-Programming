package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="DriveSquare", group="Linear OpMode")
//Disabled

public class DriveSquare extends Linear OpMode {


private ElapsedTime runtime = new ElapsedTime();
  
 DcMotor leftMotor;
 DcMotor rightMotor;
 
 double power = 0.5;
 
@Override 
  public void runOpMode() throws InterruptedException {
  
  telemetry.addData("Status", "Initialized");
  telemetry.update();
 
    leftMotor = hardwareMap.dcMotor.get("Left_Motor");
    rightMotor = hardwareMap.dcMotor.get("Right_Motor");
    
    
    leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    
    
    waitForStart();
    runtime.reset();
    
    for (int i = 0; i<4; i++ ) { 
    
    leftMotor.setPower(power);
    rightMotor.setPower(power);
    sleep(2000);
      
    leftMotor.setPower(-power);
    rightMotor.setPower(power);
    sleep(1000);
    
    
    }
    
    leftMotor.setPower(0.0);
    rightMotor.setPower(0.0);
    
    
    leftMotor.setPower(-gamepad1.left_stick_y);
    rightMotor.setPower(gamepad1.right_stick_y);
  }
}


