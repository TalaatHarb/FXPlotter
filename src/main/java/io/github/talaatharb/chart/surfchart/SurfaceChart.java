package io.github.talaatharb.chart.surfchart;

import java.util.ArrayList;
import java.util.List;

import io.github.talaatharb.utils.gui.GUIUtils;
import javafx.scene.Camera;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.ParallelCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SnapshotParameters;
import javafx.scene.SubScene;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Shape3D;

public class SurfaceChart extends AnchorPane {

	private static final double AXIS_LENGTH = 250.0;
	private static final double CAMERA_FAR_CLIP = 10000.0;
	public static final double CAMERA_INITIAL_DISTANCE = -450;
	public static final double CAMERA_INITIAL_X_ANGLE = 70.0;
	public static final double CAMERA_INITIAL_Y_ANGLE = 320.0;
	private static final double CAMERA_NEAR_CLIP = 0.1;
	private static final double DEFAULT_HEIGHT = 600;
	private static final double DEFAULT_WIDTH = 800;

	private final Xform axisGroup = new Xform();
	private final Camera camera = new ParallelCamera();
	private final Xform cameraXform1 = new Xform();
	private final Xform cameraXform2 = new Xform();
	private final Xform cameraXform3 = new Xform();
	private List<MeshView> data;
	private InputHandler inputHandler;
	private Xform modelGroup = new Xform();
	private Group rootPanel;
	private Shape3D chart;
	private SubScene scene;
	private final Xform world = new Xform();

	public SurfaceChart() {
		super();
		this.data = new ArrayList<>();

		rootPanel = new Group();
		rootPanel.getChildren().add(world);
		rootPanel.setDepthTest(DepthTest.DISABLE);
		buildCamera();
		buildAxes();
		scene = new SubScene(rootPanel, DEFAULT_WIDTH, DEFAULT_HEIGHT, true, SceneAntialiasing.BALANCED);
		world.setDepthTest(DepthTest.ENABLE);
		inputHandler = new InputHandler(scene, world, camera, cameraXform1, cameraXform2);
		scene.setCamera(camera);
		this.getChildren().add(scene);
		GUIUtils.setAnchorZeroOffset(scene);
		scene.heightProperty().bind(this.heightProperty());
		scene.widthProperty().bind(this.widthProperty());
	}

	private void buildAxes() {
		final PhongMaterial redMaterial = new PhongMaterial();
		redMaterial.setDiffuseColor(Color.DARKRED);
		redMaterial.setSpecularColor(Color.RED);

		final PhongMaterial greenMaterial = new PhongMaterial();
		greenMaterial.setDiffuseColor(Color.DARKGREEN);
		greenMaterial.setSpecularColor(Color.GREEN);

		final PhongMaterial blueMaterial = new PhongMaterial();
		blueMaterial.setDiffuseColor(Color.DARKBLUE);
		blueMaterial.setSpecularColor(Color.BLUE);

		final Box xAxis = new Box(AXIS_LENGTH, 1, 1);
		final Box yAxis = new Box(1, AXIS_LENGTH, 1);
		final Box zAxis = new Box(1, 1, AXIS_LENGTH);

		xAxis.setMaterial(redMaterial);
		yAxis.setMaterial(greenMaterial);
		zAxis.setMaterial(blueMaterial);

		axisGroup.getChildren().addAll(xAxis, yAxis, zAxis);
		axisGroup.setVisible(true);
		world.getChildren().addAll(axisGroup);
	}

	private void buildCamera() {
		rootPanel.getChildren().add(cameraXform1);
		cameraXform1.getChildren().add(cameraXform2);
		cameraXform2.getChildren().add(cameraXform3);
		cameraXform3.getChildren().add(camera);
		resetView();
	}

	public List<MeshView> getData() {
		return data;
	}

	public void resetView() {
		cameraXform3.setRotateZ(180.0);
		camera.setNearClip(CAMERA_NEAR_CLIP);
		camera.setFarClip(CAMERA_FAR_CLIP);
		camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
		cameraXform1.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
		cameraXform1.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
	}
	
	public void toggleAxes() {
		axisGroup.setVisible(!axisGroup.isVisible());
	}
	
	public final WritableImage capture() {
		return scene.snapshot(new SnapshotParameters(), null);
	}
	
	public void setViewPoint(double angleX, double angleY, double angleZ) {
		cameraXform3.setRotateZ(angleZ);
		cameraXform1.rx.setAngle(angleX);
		cameraXform1.ry.setAngle(angleY);
	}
}
