# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# NO CHECKED-IN PROTOBUF GENCODE
# source: service.proto
# Protobuf Python Version: 5.29.0
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import runtime_version as _runtime_version
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
_runtime_version.ValidateProtobufRuntimeVersion(
    _runtime_version.Domain.PUBLIC,
    5,
    29,
    0,
    '',
    'service.proto'
)
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\rservice.proto\"\x1d\n\x0b\x41utoRequest\x12\x0e\n\x06\x61utoId\x18\x01 \x01(\x05\"W\n\x0c\x41utoResponse\x12\x0e\n\x06\x61utoId\x18\x01 \x01(\x05\x12\x11\n\tautoMarca\x18\x02 \x01(\t\x12\x12\n\nautoModelo\x18\x03 \x01(\t\x12\x10\n\x08\x61utoAnio\x18\x04 \x01(\t\"\x07\n\x05\x45mpty\"\x1b\n\x08Response\x12\x0f\n\x07message\x18\x01 \x01(\t29\n\x0b\x41utoService\x12*\n\x0bObtenerAuto\x12\x0c.AutoRequest\x1a\r.AutoResponseb\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'service_pb2', _globals)
if not _descriptor._USE_C_DESCRIPTORS:
  DESCRIPTOR._loaded_options = None
  _globals['_AUTOREQUEST']._serialized_start=17
  _globals['_AUTOREQUEST']._serialized_end=46
  _globals['_AUTORESPONSE']._serialized_start=48
  _globals['_AUTORESPONSE']._serialized_end=135
  _globals['_EMPTY']._serialized_start=137
  _globals['_EMPTY']._serialized_end=144
  _globals['_RESPONSE']._serialized_start=146
  _globals['_RESPONSE']._serialized_end=173
  _globals['_AUTOSERVICE']._serialized_start=175
  _globals['_AUTOSERVICE']._serialized_end=232
# @@protoc_insertion_point(module_scope)
