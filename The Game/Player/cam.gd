extends Node3D

@export var sensitivity = 5.0
var maxZoom = 10
var minZoom = 2
func _ready():
	Input.mouse_mode = Input.MOUSE_MODE_CAPTURED

func _process(delta):
	#global_position = $".." global_position
	pass

func _input(event):
	if event is InputEventMouseMotion:
		var xRO = clamp(rotation.x - event.relative.y/1000 * sensitivity, -0.25, 0.5)
		var yRO = rotation.y - event.relative.x/1000 * sensitivity
		rotation = Vector3(xRO, yRO, 0)

	if event is InputEventMouseButton:
		if event.button_index == 5:
			if get_node("SpringArm3D").sprint_length < maxZoom:
				get_node("SpringArm3D").spring_length += 0.1
		if event.button_index == 4:
			if get_node("SprintArm3D").sprint_length > minZoom: 
				get_node("SpringArm3D").spring_length -= 0.1
