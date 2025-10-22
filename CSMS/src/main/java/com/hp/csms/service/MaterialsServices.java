package com.hp.csms.service;

import java.util.List;

import com.hp.csms.entity.Materials;

public interface MaterialsServices {

	boolean addMaterial(Materials material);

	List<Materials> getAllMaterials();

	Materials getMaterial(int material_id);

	boolean updateMaterial(Materials material);

	boolean deleteMaterial(int material_id);

}
